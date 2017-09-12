package cn.bestwu.apidoc

import com.beust.klaxon.*
import java.io.File
import java.io.PrintWriter

/**
 * 生成MD接口文档
 *
 * @author Peter Wu
 */
object MDGenerator {

    /**
     * 严格模式字段解析
     */
    val strict = true

    @Suppress("UNCHECKED_CAST")
    fun call(apidocExtension: ApidocExtension) {
        apidocExtension.paths.forEach { path ->
            val sourcePath = apidocExtension.sourcePath + "/" + path
            val input = File(sourcePath)
            val output = File(input, "md")
            val cover = apidocExtension.cover
            if (cover) {
                output.deleteRecursively()
            }
            if (!output.exists()) {
                output.mkdirs()
            }

            val parser = Parser()
            val trees = parser.parse(File(input, "tree.json").inputStream()) as JsonArray<JsonObject>
            val apis = parser.parse(File(input, "api.json").inputStream()) as JsonArray<JsonObject>
            val fields = parser.parse(File(input, "field.json").inputStream()) as JsonArray<JsonObject>

            trees.forEachIndexed { i, tree ->
                val field = File(input, "field/${tree["text"]}.json")
                val tempfields = JsonArray<JsonObject>()
                tempfields.addAll(fields)
                if (field.exists()) {
                    tempfields.addAll(parser.parse(field.inputStream()) as JsonArray<JsonObject>)
                }
                val apiHost = if (apidocExtension.apiHost.isEmpty()) apidocExtension.defaultHost else apidocExtension.apiHost
                MDGenerator.call(tree, apis, tempfields, output, apiHost, cover, i + 1)

            }
        }


    }

    /**
     * 生成文档
     * @param i
     * @param tree
     * @param apis
     * @param fields
     * @param output
     * @param apiHost
     * @param cover
     */
    fun call(tree: JsonObject, apis: JsonArray<JsonObject>, fields: JsonArray<JsonObject>, output: File, apiHost: String, cover: Boolean = true, i: Int = -1) {
        if (!output.exists()) {
            output.mkdirs()
        }
        val treeName = tree.string("text")!!
        val fileName: String
        fileName = if (i > -1)
            "${if (i < 10) "0" + i else i.toString()}-$treeName"
        else
            treeName

        val file = File(output, "$fileName.md")
        if (!file.exists() || cover) {
            println("生成：$file")
            file.printWriter().use { out ->
                generateFile(out, i, apis, tree, fields, apiHost)
            }
        } else if (file.exists() && !cover) {
            println("追加：$file")
            file.printWriter().use { out ->
                generateFile(out, i, apis, tree, fields, apiHost)
            }
        } else {
            println("$file 已存在")
        }

    }

    /**
     * 生成文件
     * @param out
     * @param i
     * @param apis
     * @param tree
     * @param fields
     * @param apiHost
     */
    private fun generateFile(out: PrintWriter, i: Int, apis: JsonArray<JsonObject>, tree: JsonObject, fields: JsonArray<JsonObject>, apiHost: String) {
        val treeName = tree.string("text")!!
        if (i > -1)
            out.println("### $i $treeName ###")
        else
            out.println("### $treeName ###")
        out.println()
        tree.array<JsonObject>("children")!!.forEachIndexed { index, leaf ->
            var m = index
            m++
            val leafName = leaf.string("text")!!
            if (i > -1)
                out.println("#### $i.$m $leafName ####")
            else
                out.println("#### $m $leafName ####")
            out.println()
            val api = apis.find({ api ->
                api.string("resource") == treeName && api.string("name") == leafName
            }) ?: throw Exception("未找到[$treeName#$leafName]接口")
            out.println("###### 接口地址 ######")
            out.println()
            out.println("[${apiHost + api.string("url")}](${apiHost + api.string("url")})")
            out.println()
            out.println("###### 请求方法 ######")
            out.println("${api.string("method")}")
            out.println()
            val desc = api.string("desc")
            if (!desc.isNullOrBlank()) {
                out.println("###### 说明 ######")
                out.println("$desc")
                out.println()
            }

            val version = api["version"]
            if (version is JsonArray<*>)
                version.forEach {
                    out.println("###### 接口版本$it ######")
                    fillDesc(out, api, fields, it as String)
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
    private fun fillDesc(out: PrintWriter, api: JsonObject, fields: JsonArray<JsonObject>, version: String? = null) {
        var headers = api.obj("headers")
        var uriVariables = api["uriVariables"] as? JsonObject
        var params = api.obj("params")
        var results = api["results"]
        if (!version.isNullOrBlank() && "1.0" != version && api.obj(version!!) != null) {
            val apiVersion = api.obj(version)!!
            if (apiVersion.obj("headers") != null)
                headers = apiVersion.obj("headers")
            if (apiVersion["uriVariables"] != null)
                uriVariables = api["uriVariables"] as? JsonObject
            if (apiVersion.obj("params") != null)
                params = apiVersion.obj("params")
            if (apiVersion["results"] != null)
                results = apiVersion["results"]
        }

        val headerFields = getParamFields(fields, headers)
        if (headerFields.isNotEmpty()) {
            out.println()
            out.println("###### 请求头参数 ######")
            out.println()
            out.println("|名称|类型|是否必填|描述|示例值|")
            out.println("|---|---|---|---|---|")
            headerFields.forEach {
                out.println("| ${it["name"]} | ${it["type"]} | ${it["nullableDesc"]} | ${it["desc"]} | ${it["tempValue"]} |")
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
                out.println("| ${it["name"]} | ${it["type"]} | ${it["desc"]} | ${it["tempValue"]} |")
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
            paramFields.forEach() {
                out.println("| ${it["name"]} | ${it["type"]} | ${it["nullableDesc"]} | ${it["desc"]} | ${it["value"]} | ${it["tempValue"]} |")
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
                out.println("| ${it["name"]} | ${it["type"]} | ${it["desc"]} | ${it["tempValue"]} |")
            }

            out.println()
            out.println("###### 响应示例 ######")
            out.println()
            out.println("```json")
            out.println(convertResults(fields, results as JsonBase).toJsonString(true))
            out.println("```")
        }
    }

    /**
     * 转换结果示例
     * @param fields
     * @param results
     * @return
     */
    private fun convertResults(fields: JsonArray<JsonObject>, results: JsonBase): JsonBase {
        if (results is JsonArray<*>) {
            val convertedResults = JsonArray<JsonBase>()
            results.forEach {
                convertedResults.add(convertResults(fields, it as JsonBase))
            }
            return convertedResults
        } else if (results is JsonObject) {
            val convertedResults = JsonObject()
            results.forEach { (k, v) ->
                val field = findField(fields, k, v)
                var value = v
                if (value == null || "" == v) {
                    value = field["value"]
                }
                if (value is JsonBase) {
                    value = convertResults(fields, value)
                }
                convertedResults.put(field.string("name")!!, value)
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
    private fun getParamFields(fields: JsonArray<JsonObject>, param: JsonObject?): List<JsonObject> {
        if (param == null || param.isEmpty())
            return listOf<JsonObject>()
        val flds = mutableListOf<JsonObject>()
        param.forEach { (k, v) ->
            var nullable: Boolean? = null
            val name: String
            if (k.endsWith("&")) {
                nullable = false
                name = k.substring(0, k.length - 1)
            } else if (k.endsWith("^")) {
                nullable = true
                name = k.substring(0, k.length - 1)
            } else {
                name = k
            }
            var tempDesc: String? = null
            var value: Any? = v
            if (value is JsonObject) {
                tempDesc = value["desc"] as String
                value = value["value"]
            }

            val field = findField(fields, name, value)

            if (nullable == null) {
                nullable = field.boolean("nullable") ?: true
            }
            field["nullableDesc"] = if (nullable) "否" else "是"

            if (value == null || "" == value) {
                value = field["value"]
            }
            field["tempValue"] = value
            if (field["tempValue"] is JsonArray<*> && (field["tempValue"] as JsonArray<*>).size == 1)
                field["tempValue"] = (field["tempValue"] as JsonArray<*>)[0]

            if (tempDesc != null)
                field["desc"] = tempDesc
            field["desc"] = (field.getOrElse("desc", { "" }) as String).replace("href=\"html/", "href=\"").replace(".html\"", ".md\"")

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
    private fun getResultFields(fields: JsonArray<JsonObject>, result: Any?): List<JsonObject> {
        if (result == null)
            return listOf<JsonObject>()
        val flds = mutableListOf<JsonObject>()
        var rs = result
        if (result is JsonArray<*>) {
            if (result.size == 0) {
                return listOf<JsonObject>()
            }
            rs = result[0]
        }
        (rs as JsonObject).forEach { (k, v) ->
            val field = findField(fields, k, v)
            var value = v
            if (value == null || "" == value || value is JsonObject && value.size == 0 || value is JsonArray<*> && value.size == 0) {
                value = field["value"]
            }
            when (value) {
                is JsonObject -> field["tempValue"] = convertResults(fields, value).toJsonString().replace("[", "\\[")
                is JsonArray<*> -> {
                    val list = JsonArray<Any?>()
                    if (value.size >= 1) {
                        value = value[0]
                        list.add(value)
                    }
                    field["tempValue"] = convertResults(fields, list).toJsonString().replace("[", "\\[")
                }
                else -> field["tempValue"] = value
            }

            fillDefaultField(field)

            flds.add(field)
            if (value is JsonObject && value.size > 0) {
                flds.addAll(getResultFields(fields, value))
            }
        }
        return flds
    }

    /**
     * 填充默认值
     */
    private fun fillDefaultField(field: JsonObject) {
        if (null == field["desc"] || "" == field["desc"] || "-" == field["desc"])
            field["desc"] = "\\-"
        if (null == field["value"] || "" == field["value"] || "-" == field["value"])
            field["value"] = "\\-"
        if (null == field["type"] || "" == field["type"] || "-" == field["type"])
            field["type"] = "\\-"
        if (null == field["tempValue"] || "" == field["tempValue"] || "-" == field["tempValue"])
            field["tempValue"] = "\\-"
    }

    /**
     * 转换字段类型
     * @param value
     */
    private fun getFieldType(value: Any?): String {
        if (value == null)
            return ""
        if (value is JsonObject)
            return "Object"
        if (value is JsonArray<*>)
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
    private fun findField(fields: JsonArray<JsonObject>, name: String, value: Any?): JsonObject {
        var origin: JsonObject? = null
        var result = fields.filter {
            val id = it.string("id")
            !id.isNullOrBlank() && id == name
        }

        var size = result.size
        if (strict && size > 1)
            throw  RuntimeException("id:$name 存在多个未区分属性说明：${result.joinToString { it.toJsonString(true) }}")
        if (size > 0) {
            origin = result[0]
        } else {
            val type = getFieldType(value)
            result = fields.filter {
                it.string("id") == null && it.string("name") == name && it.string("type") == type
            }
            size = result.size
            if (strict && size > 1)
                throw RuntimeException("name:$name,type:$type 存在多个未区分属性说明：${result.joinToString { it.toJsonString(true) }}")
            if (size > 0) {
                origin = result[0]
            } else {
                result = fields.filter {
                    it.string("id") == null && it.string("name") == name
                }
                size = result.size
                if (strict && size > 1)
                    throw RuntimeException("name:$name 存在多个未区分属性说明：${result.joinToString { it.toJsonString(true) }}")
                if (size > 0) {
                    origin = result[0]
                }
            }
        }
        if (origin == null) {
            origin = JsonObject(mapOf(Pair("name", name)))
        }
        return JsonObject(origin.map.toMap())
    }
}