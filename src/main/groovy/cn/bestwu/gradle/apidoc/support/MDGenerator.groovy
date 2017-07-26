package cn.bestwu.gradle.apidoc.support

import groovy.json.JsonOutput

/**
 * 生成MD接口文档
 *
 * @author Peter Wu
 */
class MDGenerator {

    /**
     * 严格模式字段解析
     */
    static strict = true

    /**
     * 生成文档
     * @param i
     * @param tree
     * @param apis
     * @param fields
     * @param output
     * @param apiHost
     * @param cover
     * @param encoding
     * @return
     */
    static generate(i, tree, apis, fields, output, apiHost, cover, encoding) {
        if (!output.exists()) {
            output.mkdirs()
        }
        def treeName = tree.text
        def fileName
        if (i)
            fileName = "${i < 10 ? '0' + i : i}-${treeName}"
        else
            fileName = treeName

        def file = new File(output, "${fileName}.md")
        if (!file.exists() || cover) {
            println("生成：${file}")
            file.withPrintWriter(encoding) { out ->
                generateFile(out, i, apis, tree, fields, apiHost)
            }
        } else if (file.exists() && !cover) {
            println("追加：${file}")
            file.withWriterAppend(encoding, { out ->
                generateFile(out, i, apis, tree, fields, apiHost)
            })
        } else {
            println("${file}已存在")
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
    private static void generateFile(out, i, apis, tree, fields, apiHost) {
        def treeName = tree.text
        if (i)
            out.println "### ${i} ${treeName} ###"
        else
            out.println "### ${treeName} ###"
        out.println ''
        tree.children.eachWithIndex() {
            leaf, m ->
                m++
                def leafName = leaf.text
                if (i)
                    out.println "#### ${i}.${m} ${leafName} ####"
                else
                    out.println "#### ${m} ${leafName} ####"
                out.println ''
                def api = apis.find({
                    api ->
                        api.resource == treeName && api.name == leafName
                })
                if (api == null)
                    throw new Exception("未找到[${treeName}#${leafName}]接口")
                out.println "###### 接口地址 ######"
                out.println ''
                out.println "[${apiHost + api.url}](${apiHost + api.url})"
                out.println ''
                out.println "###### 请求方法 ######"
                out.println "${api.method}"
                out.println ''
                if (api.desc) {
                    out.println "###### 说明 ######"
                    out.println "${api.desc}"
                    out.println ''
                }

                if (api.version && api.version.class == ArrayList.class) {
                    api.version.each {
                        fillDesc(out, api, fields, it)
                    }
                } else
                    fillDesc(out, api, fields, null)

                out.println ''
                out.println '---'
        }
    }

    /**
     * 填充文档
     * @param out
     * @param api
     * @param fields
     * @param version
     * @return
     */
    static fillDesc(out, api, fields, version) {
        def headers = api.headers
        def uriVariables = api.uriVariables
        def params = api.params
        def results = api.results
        if (version && '1.0' != version && api[version]) {
            if (api[version].headers)
                headers = api[version].headers
            if (api[version].uriVariables)
                uriVariables = api[version].uriVariables
            if (api[version].params)
                params = api[version].params
            if (api[version].results)
                results = api[version].results
        }

        headers = getParamFields(fields, headers)
        if (headers != null && !headers.isEmpty()) {
            out.println ''
            out.println "###### 请求头参数 ######"
            out.println ''
            out.println "|名称|类型|是否必填|描述|示例值|"
            out.println "|---|---|---|---|---|"
            headers.each {
                out.println "| ${it.name} | ${it.type} | ${it.nullableDesc} | ${it.desc} | ${it.tempValue} |"
            }
        }
        uriVariables = getParamFields(fields, uriVariables)
        if (uriVariables != null && !uriVariables.isEmpty()) {
            out.println ''
            out.println "###### URL参数 ######"
            out.println ''
            out.println "|名称|类型|描述|示例值|"
            out.println "|---|---|---|---|"
            uriVariables.eachWithIndex {
                it, index ->
                    out.println "| ${it.name} | ${it.type} | ${it.desc} | ${it.tempValue} |"
            }
        }
        out.println ''
        out.println "###### 请求参数 ######"
        out.println ''

        params = getParamFields(fields, params)
        if (params == null || params.isEmpty()) {
            out.println "无"
        } else {
            out.println "|名称|类型|是否必填|描述|默认值|示例值|"
            out.println "|---|---|---|---|---|---|"
            params.each {
                out.println "| ${it.name} | ${it.type} | ${it.nullableDesc} | ${it.desc} | ${it.value} | ${it.tempValue} |"
            }
        }
        out.println ''
        out.println "###### 响应参数 ######"
        out.println ''

        def resultFields = getResultFields(fields, results)
        if (resultFields == null || resultFields.isEmpty()) {
            out.println "无"
        } else {
            out.println "|名称|类型|描述|示例值|"
            out.println "|---|---|---|---|"
            resultFields.each {
                out.println "| ${it.name} | ${it.type} | ${it.desc} | ${it.tempValue} |"
            }

            out.println ''
            out.println "###### 响应示例 ######"
            out.println ''
            out.println '```json'
            out.println UnescapeUnicodeUtil.unescapeUnicode(JsonOutput.prettyPrint(JsonOutput.toJson(convertResults(fields, results))))
            out.println '```'
        }
    }
    /**
     * 转换结果示例
     * @param fields
     * @param results
     * @return
     */
    static convertResults(fields, results) {
        if (results instanceof Collection) {
            def convertedResults = []
            results.each {
                convertedResults.add(convertResults(fields, it))
            }
            return convertedResults
        } else {
            def convertedResults = new LinkedHashMap()
            results.each() {
                k, v ->
                    def field = findField(fields, k, v)
                    if (v == null || '' == v) {
                        v = field.value
                    }
                    if (v instanceof Map || v instanceof Collection) {
                        v = convertResults(fields, v)
                    }
                    convertedResults.put(field.name, v)
            }
            return convertedResults
        }
    }
    /**
     * 参数字段
     * @param fields
     * @param param
     * @return
     */
    static getParamFields(fields, param) {
        if (!param)
            return null
        def flds = []
        param.each { k, v ->
            def nullable = null, name
            if (k.endsWith('&')) {
                nullable = false
                name = k.substring(0, k.length() - 1)
            } else if (k.endsWith('^')) {
                nullable = true
                name = k.substring(0, k.length() - 1)
            } else {
                name = k
            }
            def tempDesc = null
            if (v instanceof Map) {
                tempDesc = v['desc']
                v = v['value']
            }

            def field = findField(fields, name, v)

            if (nullable == null) {
                nullable = field.nullable
            }
            if (nullable == null) {
                nullable = true
            }
            field.nullableDesc = nullable ? '否' : '是'

            if (v == null || '' == v) {
                v = field.value
            }
            field.tempValue = v

            if (field.desc == null || '' == field.desc || '-' == field.tempValue)
                field.desc = '\\-'
            if (field.type == null)
                field.type = 'String'
            field.desc = field.desc.replace('href=\'html/', 'href=\'').replace('.html\'', '.md\'')
            if (field.value == null || '' == field.value || '-' == field.tempValue)
                field.value = '\\-'
            if (field.tempValue == null || '' == field.tempValue || '-' == field.tempValue)
                field.tempValue = '\\-'

            if (getFieldType(field.tempValue) == 'Array' && field.tempValue.size() == 1)
                field.tempValue = field.tempValue[0]

            if (tempDesc != null)
                field.desc = tempDesc
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
    static getResultFields(fields, result) {
        if (!result)
            return null
        def flds = []
        if (result instanceof Collection) {
            if (result.size() == 0) {
                return null
            }
            result = result[0]
        }
        result.each { k, v ->
            def field = findField(fields, k, v)

            if (v == null || '' == v || ((v instanceof Map || v instanceof Collection) && v.size() == 0)) {
                v = field.value
            }
            if (v instanceof Map)
                field.tempValue = UnescapeUnicodeUtil.unescapeUnicode(JsonOutput.toJson(convertResults(fields, v)).replace('[', '\\['))
            else if (v instanceof Collection) {
                def list
                if (v.size() >= 1) {
                    v = v[0]
                    list = Collections.singletonList(v)
                } else {
                    list = []
                }
                field.tempValue = UnescapeUnicodeUtil.unescapeUnicode(JsonOutput.toJson(convertResults(fields, list)).replace('[', '\\['))
            } else
                field.tempValue = v

            if (field.type == null)
                field.type = 'String'
            if (field.desc == null || '' == field.desc)
                field.desc = '\\-'
            if (field.value == null || '' == field.value)
                field.value = '\\-'
            if (field.tempValue == null || '' == field.tempValue)
                field.tempValue = '\\-'

            flds.add(field)
            if (v instanceof Map && v.size() > 0) {
                flds.addAll(getResultFields(fields, v))
            }
        }
        result = flds
        return result
    }

    /**
     * 转换字段类型
     * @param value
     */
    static getFieldType(value) {
        if (value instanceof Map)
            return 'Object'
        if (value instanceof Collection || value.class.isArray())
            return 'Array'
        return value.class.simpleName
    }
    /**
     * 查找字段
     * @param fields
     * @param name
     * @param value
     * @return
     */
    static findField(fields, name, value) {
        def origin
        def result = fields.findAll {
            if (it.id && it.id == name) {
                return it
            }
        }
        def size = result.size()
        if (strict && size > 1)
            throw new RuntimeException("id:${name}存在多个未区分属性说明：${UnescapeUnicodeUtil.unescapeUnicode(JsonOutput.toJson(result))}")
        if (size > 0) {
            origin = result[0]
        } else {
            def type = getFieldType(value)
            result = fields.findAll {
                if (!it.id && it.name == name && it.type.contains(type)) {
                    return it
                }
            }
            size = result.size()
            if (strict && size > 1)
                throw new RuntimeException("name:${name},type:${type}存在多个未区分属性说明：${UnescapeUnicodeUtil.unescapeUnicode(JsonOutput.toJson(result))}")
            if (size > 0) {
                origin = result[0]
            } else {
                result = fields.findAll {
                    if (!it.id && it.name == name) {
                        return it
                    }
                }
                size = result.size()
                if (strict && size > 1)
                    throw new RuntimeException("name:${name}存在多个未区分属性说明：${UnescapeUnicodeUtil.unescapeUnicode(JsonOutput.toJson(result))}")
                if (size > 0) {
                    origin = result[0]
                }
            }
        }
        if (origin == null) {
            origin = [name: name]
        }

        def field = new HashMap()
        copyProperties(origin, field)

        return field
    }
    /**
     * 复制属性
     * @param source
     * @param target
     * @return
     */
    static copyProperties(source, target) {
        source.each { key, value ->
            target[key] = value
        }
    }
}