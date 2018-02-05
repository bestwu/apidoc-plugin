package cn.bestwu.apidoc

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.type.TypeFactory
import java.io.File
import java.io.PrintWriter

/**
 * 生成MD接口文档
 *
 * @author Peter Wu
 */
object MDGenerator {

    private var apidocExtension: ApidocExtension = ApidocExtension()
    private var apis: List<Api> = emptyList()
    private val apiHost: String
        get() = if (apidocExtension.apiHost.isEmpty()) apidocExtension.defaultHost else apidocExtension.apiHost

    private val objectMapper = ObjectMapper()

    init {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_INDEX)
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        objectMapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION)
    }

    private fun Any.toJsonString(prettyPrint: Boolean = false): String {
        if (prettyPrint) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT)
        } else {
            objectMapper.disable(SerializationFeature.INDENT_OUTPUT)
        }
        return objectMapper.writeValueAsString(this)
    }

    @Suppress("UNCHECKED_CAST")
    fun call(apidocExtension: ApidocExtension) {
        this.apidocExtension = apidocExtension
        apidocExtension.paths.forEach { path ->
            val sourcePath = apidocExtension.sourcePath + "/" + path
            val input = File(sourcePath)
            if (input.exists()) {
                val output = File(input, "md")
                if (apidocExtension.cover) {
                    output.deleteRecursively()
                }
                if (!output.exists()) {
                    output.mkdirs()
                }

                val trees: List<Tree> = File(input, "tree.json").parse(Tree::class.java)
                apis = File(input, "api.json").parse(Api::class.java)
                val defaultFields: List<Field> = File(input, "field.json").parse(Field::class.java)


                trees.forEachIndexed { i, tree ->
                    val field = File(input, "field/${tree.text}.json")
                    val tempfields = mutableListOf<Field>()
                    tempfields.addAll(defaultFields)
                    if (field.exists()) {
                        tempfields.addAll(field.parse(Field::class.java))
                    }

                    val j = i + 1

                    val treeName = tree.text
                    val fileName: String
                    fileName = if (j > -1)
                        "${if (j < 10) "0" + j else j.toString()}-$treeName"
                    else
                        treeName

                    val file = File(output, "$fileName.md")
                    if (!file.exists() || MDGenerator.apidocExtension.cover) {
                        println("生成：$file")
                        file.printWriter().use { out ->
                            generateFile(out, j, tree, tempfields)
                        }
                    } else if (file.exists() && !MDGenerator.apidocExtension.cover) {
                        println("追加：$file")
                        file.printWriter().use { out ->
                            generateFile(out, j, tree, tempfields)
                        }
                    } else {
                        println("$file 已存在")
                    }

                }
            }
        }


    }

    private fun <T> File.parse(clazz: Class<T>): List<T> =
            objectMapper.readValue(this, TypeFactory.defaultInstance().constructCollectionType(List::class.java, clazz))


    /**
     * 生成文件
     * @param out
     * @param i
     * @param tree
     * @param fields
     */
    private fun generateFile(out: PrintWriter, i: Int, tree: Tree, fields: List<Field>) {
        val treeName = tree.text
        if (i > -1)
            out.println("### $i $treeName ###")
        else
            out.println("### $treeName ###")
        out.println()
        tree.children?.forEachIndexed { index, leaf ->
            var m = index
            m++
            val leafName = leaf.text
            val indexLeafName =
                    if (i > -1)
                        "$i.$m $leafName"
                    else
                        "$m $leafName"
            out.println("#### $indexLeafName ####")
            out.println()
            val api = apis.find({ api ->
                api.resource == treeName && api.name == leafName
            }) ?: throw Exception("未找到[$treeName#$leafName]接口")

            val author = if (api.author.isNullOrBlank()) apidocExtension.author else api.author
            if (!author.isNullOrBlank()) {
                out.println("###### 开发者 ######")
                out.println(author!!.replace("<", "&lt;").replace(">", " &gt;"))
                out.println()
            }

            out.println("###### 接口地址 ######")
            out.println()
            out.println("[${apiHost + api.url}](${apiHost + api.url})")
            out.println()
            out.println("###### 请求方法 ######")
            out.println(api.method)
            out.println()

            val version = api.version
            if (version is List<*>)
                version.forEach {
                    out.println("###### 接口版本 ######")
                    out.println(it)
                    fillDesc(out, api, fields, it)
                }
            else {
                fillDesc(out, api, fields)
            }
            out.println()
            out.println("---")
        }
    }

    /**
     * 填充文档
     * @param out
     * @param api
     * @param fields
     * @param version
     */
    @Suppress("UNCHECKED_CAST")
    private fun fillDesc(out: PrintWriter, api: Api, fields: List<Field>, version: String? = null) {
        var headers = api.headers
        var uriVariables = api.uriVariables
        var params = api.params
        var results = api.results
        var desc = api.desc
        if (!version.isNullOrBlank() && "1.0" != version && api[version!!] != null) {
            val apiVersion = api[version]!!
            if (!apiVersion.desc.isNullOrBlank())
                desc = apiVersion.desc
            if (apiVersion.headers != null)
                headers = apiVersion.headers
            if (apiVersion.uriVariables != null)
                uriVariables = api.uriVariables
            if (apiVersion.params != null)
                params = apiVersion.params
            if (apiVersion.results != null)
                results = apiVersion.results
        }

        if (!desc.isNullOrBlank()) {
            out.println("###### 说明 ######")
            out.println("$desc")
            out.println()
        }
        val headerFields = getParamFields(fields, headers)
        if (headerFields.isNotEmpty()) {
            out.println()
            out.println("###### 请求头参数 ######")
            out.println()
            out.println("|名称|类型|是否必填|描述|示例值|")
            out.println("|---|---|---|---|---|")
            headerFields.forEach {
                out.println("| ${it.name} | ${it.type} | ${it.nullableDesc} | ${it.desc} | ${it.tempValue} |")
            }
        }
        val uriVariableFields = getParamFields(fields, uriVariables)
        if (uriVariableFields.isNotEmpty()) {
            out.println()
            out.println("###### URL参数 ######")
            out.println()
            out.println("|名称|类型|描述|示例值|")
            out.println("|---|---|---|---|")
            uriVariableFields.forEach {
                out.println("| ${it.name} | ${it.type} | ${it.desc} | ${it.tempValue} |")
            }
        }
        out.println()
        out.println("###### 请求参数 ######")
        out.println()

        val paramFields = getParamFields(fields, params)
        if (paramFields.isEmpty()) {
            out.println("无")
        } else {
            out.println("|名称|类型|是否必填|描述|默认值|示例值|")
            out.println("|---|---|---|---|---|---|")
            paramFields.forEach {
                out.println("| ${it.name} | ${getType(it)} | ${it.nullableDesc} | ${it.desc} | ${it.value} | ${it.tempValue} |")
            }
        }
        out.println()
        out.println("###### 响应参数 ######")
        out.println()

        val resultFields = getResultFields(fields, results)
        if (resultFields.isEmpty()) {
            out.println("无")
        } else {
            out.println("|名称|类型|描述|示例值|")
            out.println("|---|---|---|---|")
            resultFields.forEach {
                out.println("| ${it.name} | ${getType(it)} | ${it.desc} | ${it.tempValue} |")
            }
        }
        if (results != null && results.toString().isNotBlank()) {
            out.println()
            out.println("###### 响应示例 ######")
            out.println()
            out.println("```json")
            out.println(convertResults(fields, results)?.toJsonString(true))
            out.println("```")
        }
    }

    private fun getType(it: Field) = it.type?.replace("<", "&lt;")?.replace(">", "&gt;")

    /**
     * 转换结果示例
     * @param fields
     * @param results
     * @return
     */
    private fun convertResults(fields: List<Field>, results: Any?): Any? {
        if (results is List<*>) {
            val convertedResults = mutableListOf<Any?>()
            results.forEach {
                convertedResults.add(convertResults(fields, it))
            }
            return convertedResults
        } else if (results is MutableMap<*, *>) {
            val convertedResults = mutableMapOf<String, Any?>()
            results.forEach { (k, v) ->
                val field = findField(fields, k as String, v)
                var value = v
                if ((value == null || "" == v) && field.value != null) {
                    value = field.value
                }
                if (value is List<*> || value is MutableMap<*, *>) {
                    value = convertResults(fields, value)
                }
                convertedResults.put(field.name, value)
            }
            return convertedResults
        }
        return results
    }

    /**
     * 参数字段
     * @param fields
     * @param param
     * @return
     */
    private fun getParamFields(fields: List<Field>, param: Map<String, Any?>?): List<Field> {
        if (param == null || param.isEmpty())
            return listOf()
        val flds = mutableListOf<Field>()
        param.forEach { (k, v) ->
            var nullable: Boolean? = null
            val name: String
            when {
                k.endsWith("&") -> {
                    nullable = false
                    name = k.substring(0, k.length - 1)
                }
                k.endsWith("^") -> {
                    nullable = true
                    name = k.substring(0, k.length - 1)
                }
                else -> name = k
            }
            var tempDesc: String? = null
            var value: Any? = v
            if (value is Map<*, *>) {
                tempDesc = value["desc"] as String
                value = value["value"]
            }

            val field = findField(fields, name, value)

            if (nullable != null) {
                field.nullable = nullable
            }

            if (value == null || "" == value) {
                value = field.value
            }
            field.tempValue = value
            if (field.tempValue is List<*> && (field.tempValue as List<*>).size == 1)
                field.tempValue = (field.tempValue as List<*>)[0]

            if (tempDesc != null)
                field.desc = tempDesc
            field.desc = field.desc?.replace("href=\"html/", "href=\"")?.replace(".html\"", ".md\"") ?: ""

            fillDefaultField(field)

            flds.add(field)
        }
        return flds
    }


    /**
     * 响应结果字段
     * @param fields
     * @param result
     * @return
     */
    private fun getResultFields(fields: List<Field>, result: Any?): List<Field> {
        if (result == null)
            return listOf()
        val flds = mutableListOf<Field>()
        var rs = result
        if (result is List<*>) {
            if (result.size == 0) {
                return listOf()
            }
            rs = result[0]
        }
        if (rs is MutableMap<*, *>) {
            @Suppress("UNCHECKED_CAST")
            (rs as MutableMap<String, Any?>).forEach { (k, v) ->
                val field = findField(fields, k, v)
                var value = v
                if (value == null || "" == value || value is MutableMap<*, *> && value.size == 0 || value is List<*> && value.size == 0) {
                    value = field.value
                }
                when (value) {
                    is MutableMap<*, *> -> field.tempValue = convertResults(fields, value)?.toJsonString()?.replace("[", "\\[")
                    is List<*> -> {
                        val list = mutableListOf<Any?>()
                        if (value.size >= 1) {
                            value = value[0]
                            list.add(value)
                        }
                        field.tempValue = convertResults(fields, list)?.toJsonString()?.replace("[", "\\[")
                    }
                    else -> field.tempValue = value
                }

                fillDefaultField(field)

                flds.add(field)
                if (field.expanded ?: apidocExtension.expanded && value is MutableMap<*, *> && value.size > 0) {
                    flds.addAll(getResultFields(fields, value))
                }
            }
        }
        return flds
    }

    /**
     * 填充默认值
     */
    private fun fillDefaultField(field: Field) {
        if (null == field.desc || "" == field.desc || "-" == field.desc)
            field.desc = "\\-"
        if (null == field.value || "" == field.value || "-" == field.value)
            field.value = "\\-"
        if (null == field.type || "" == field.type || "-" == field.type)
            field.type = "\\-"
        if (null == field.tempValue || "" == field.tempValue || "-" == field.tempValue)
            field.tempValue = "\\-"
    }

    /**
     * 转换字段类型
     * @param value
     */
    private fun getFieldType(value: Any?): String {
        if (value == null)
            return ""
        if (value is MutableMap<*, *>)
            return "Object"
        if (value is List<*>)
            return "Array"
        return value::class.java.simpleName
    }

    /**
     * 查找字段
     * @param fields
     * @param name
     * @param value
     * @return
     */
    private fun findField(fields: List<Field>, name: String, value: Any?): Field {
        var origin: Field? = null
        var result = fields.filter {
            val id = it.id
            !id.isNullOrBlank() && id == name
        }

        var size = result.size
        if (apidocExtension.strict && size > 1)
            throw  RuntimeException("id:$name 存在多个未区分属性说明：${result.toJsonString(true)}")
        if (size > 0) {
            origin = result[0]
        } else {
            val type = getFieldType(value)
            result = fields.filter {
                it.id.isNullOrBlank() && it.name == name && it.type == type
            }
            size = result.size
            if (apidocExtension.strict && size > 1)
                throw RuntimeException("name:$name,type:$type 存在多个未区分属性说明：${result.toJsonString(true)}")
            if (size > 0) {
                origin = result[0]
            } else {
                result = fields.filter {
                    it.id.isNullOrBlank() && it.name == name
                }
                size = result.size
                if (apidocExtension.strict && size > 1)
                    throw RuntimeException("name:$name 存在多个未区分属性说明：${result.toJsonString(true)}")
                if (size > 0) {
                    origin = result[0]
                }
            }
        }
        if (origin == null) {
            origin = Field()
            origin.name = name
        }
        return origin.copy()
    }
}
