package cn.bestwu.apidoc.starter

import cn.bestwu.apidoc.HtmlGenerator
import cn.bestwu.apidoc.MDGenerator
import cn.bestwu.dbscript.DbScripts
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerMapping
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.io.PrintWriter
import javax.servlet.FilterChain
import javax.servlet.ServletOutputStream
import javax.servlet.WriteListener
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletResponseWrapper

/**
 * 请求日志过滤器
 *
 * @author Peter Wu
 * @since 0.0.1
 */
class ApiDocFilter(private var dbScriptProperties: DbScriptProperties, private var apidocProperties: ApidocProperties) : OncePerRequestFilter() {

    private val parser = Parser()
    private var objectMapper: ObjectMapper = ObjectMapper()

    init {
        if (dbScriptProperties.path.isNullOrBlank()) {
            dbScriptProperties.path = "${apidocProperties.sourcePath}/${apidocProperties.paths[0]}"
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse,
                                  filterChain: FilterChain) {
        val isFirstRequest = !isAsyncDispatch(request)

        if (isFirstRequest) {

            val responseToUse = TraceHttpServletResponseWrapper(response)

            filterChain.doFilter(request, responseToUse)
            if (responseToUse.hasErrorToSend()) {
                responseToUse.flushBuffer()
                return
            }
            if (!isAsyncStarted(request)) {
                val handler = request.getAttribute(ApiDocInterceptor.HANDLER_METHOD) as HandlerMethod?
                if (handler != null) {
                    println("生成文档相关数据")

                    val methodAnnotation = handler.getMethodAnnotation(RequestMapping::class.java)

                    var resource = ""
                    val name = methodAnnotation.name
                    val beanType = handler.beanType
                    val classRequestMapping = beanType.getAnnotation(RequestMapping::class.java)
                    if (classRequestMapping != null) {
                        resource = classRequestMapping.name
                    }
                    if (resource.isBlank() && ApiDoc.tableNames.size == 1) {
                        resource = ApiDoc.tableNames[0]
                    }
                    if (resource.isBlank()) {
                        resource = name
                    }

                    val url = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE) as String
                    var httpMethod = ""
                    val requestMethods = methodAnnotation.method
                    requestMethods.forEachIndexed { i, requestMethod ->
                        httpMethod += requestMethod
                        if (i < requestMethods.size - 1) {
                            httpMethod += ","
                        }
                    }

                    if (httpMethod == "")
                        httpMethod = request.method

                    val uriVariables = request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE)

                    //生成相应数据

                    val path = dbScriptProperties.path
                    val trees: JsonArray<JsonObject>
                    val apis: JsonArray<JsonObject>

                    //api
                    val apifile = File(path, "api.json")
                    apis = if (apifile.exists())
                        parser.parse(apifile.inputStream()) as JsonArray<JsonObject>
                    else
                        JsonArray()

                    val api = JsonObject()
                    api["method"] = httpMethod
                    api["name"] = name
                    if (ApiDoc.needSign)
                        api["headers"] = mapOf("sign" to "")

                    val requires = ApiDoc.requires
                    val parameterMap = request.parameterMap
                    val params = JsonObject()
                    parameterMap.forEach { (k, v) ->
                        val key = if (requires.contains(k)) "$k&" else "$k^"
                        params[key] = JsonArray(*v)
                    }
                    api["params"] = params
                    api["resource"] = resource
                    api["url"] = url
                    api["desc"] = ""
                    api["version"] = apidocProperties.version.toList()
                    api["uriVariables"] = uriVariables

                    val responseBody = responseToUse.responseBody
                    val responseObj = try {
                        objectMapper.readValue(responseBody, Map::class.java)
                    } catch (e: Throwable) {
                        String(responseBody)
                    }

                    api["results"] = responseObj

                    apis.remove(apis.find {
                        it["name"] == api["name"] && it["resource"] == api["resource"]
                    })
                    apis.add(api)

                    println("${if (apifile.exists()) "更新" else "创建"}$apifile")
                    apifile.printWriter().use { out ->
                        out.println(apis.toJsonString(true))
                    }

                    //tree
                    val treefile = File(path, "tree.json")
                    trees = if (treefile.exists()) {
                        parser.parse(treefile.inputStream()) as JsonArray<JsonObject>
                    } else {
                        JsonArray()
                    }
                    var tree = trees.find { it["text"] == resource }
                    if (tree == null) {
                        tree = JsonObject()
                        tree["text"] = resource
                        tree["expanded"] = true
                        tree["children"] = JsonArray<JsonObject>()
                        trees.add(tree)
                    }
                    val children = tree["children"] as JsonArray<JsonObject>
                    var child = children.find { it["text"] == name }
                    if (child == null) {
                        child = JsonObject()
                        child["leaf"] = true
                        child["text"] = name
                        children.add(child)
                    }

                    println("${if (treefile.exists()) "更新" else "创建"}$treefile")
                    treefile.printWriter().use { out ->
                        out.println(trees.toJsonString(true))
                    }

                    //field
                    if (ApiDoc.tableNames.isNotEmpty()) {
                        val fieldFile = File(path, "field/${if (resource.isBlank()) "" else "$resource.json"}")
                        dbScriptProperties.scripts = arrayOf(DbScripts.fieldScript.path(fieldFile.absolutePath))
                        dbScriptProperties.tableNames = ApiDoc.tableNames

                        DbScripts.call(dbScriptProperties)
                        println("${if (fieldFile.exists()) "更新" else "创建"}$fieldFile")
                    }

                    MDGenerator.call(apidocProperties)
                    HtmlGenerator.call(apidocProperties)
                }
            }
        }
    }


    internal inner class TraceHttpServletResponseWrapper @Throws(IOException::class)
    constructor(response: HttpServletResponse) : HttpServletResponseWrapper(response) {

        private val traceServletOutputStream: TraceServletOutputStream

        private var status: Int = 0

        private var message: String? = null

        private var hasErrorToSend = false

        val responseBody: ByteArray
            get() = traceServletOutputStream.responseBody

        init {
            traceServletOutputStream = TraceServletOutputStream(response.outputStream)
        }

        override fun setStatus(sc: Int) {
            this.status = sc
            super.setStatus(sc)
        }

        override fun sendError(status: Int) {
            sendError(status, null)
        }

        override fun sendError(status: Int, message: String?) {
            this.status = status
            this.message = message
            this.hasErrorToSend = true
        }

        override fun getStatus(): Int {
            return if (this.hasErrorToSend) {
                this.status
            } else super.getStatus()
        }

        override fun flushBuffer() {
            if (this.hasErrorToSend && !isCommitted) {
                (response as HttpServletResponse).sendError(this.status,
                        this.message)
            }
            super.flushBuffer()
        }

        fun getMessage(): String? {
            return this.message
        }

        fun hasErrorToSend(): Boolean {
            return this.hasErrorToSend
        }


        override fun getOutputStream(): ServletOutputStream {
            return traceServletOutputStream
        }

        override fun getWriter(): PrintWriter {
            return PrintWriter(outputStream)
        }

        internal inner class TraceServletOutputStream(private val delegate: ServletOutputStream) : ServletOutputStream() {
            private val byteArrayOutputStream = ByteArrayOutputStream()

            val responseBody: ByteArray
                get() = byteArrayOutputStream.toByteArray()

            override fun isReady(): Boolean {
                return this.delegate.isReady
            }

            override fun setWriteListener(listener: WriteListener) {
                this.delegate.setWriteListener(listener)
            }

            @Throws(IOException::class)
            override fun write(b: Int) {
                this.delegate.write(b)
                byteArrayOutputStream.write(b)
            }

            @Throws(IOException::class)
            override fun flush() {
                super.flush()
                this.delegate.flush()
            }

            @Throws(IOException::class)
            override fun close() {
                super.close()
                this.delegate.close()
            }
        }
    }

}
