package cn.bestwu.gradle.apidoc.tasks

import cn.bestwu.gradle.apidoc.support.OrderedJsonParserUsingCharacterSource
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.json.StringEscapeUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

/**
 * 生成接口文档
 *
 * @author Peter Wu
 */
class MDTask extends DefaultTask {
    String encoding
    @Input
    String apiHost = ''

    @TaskAction
    run() {
        encoding = project.apidoc.encoding
        project.apidoc.paths.each { path ->
            def sourcePath = project.apidoc.sourcePath + '/' + path
            doMdTask(project.file(sourcePath), project.file(sourcePath + '/md'))
        }
    }

    def doMdTask(File input, File output) {
        if (!output.exists()) {
            output.mkdirs()
        }
        def slurper = new JsonSlurper()

        def trees = slurper.parseText(jsonFilter(new File(input, 'tree.json')))
        //        def apis = slurper.parseText(jsonFilter(new File(input, "api.json")))
        def apis = new OrderedJsonParserUsingCharacterSource().parse(jsonFilter(new File(input, "api.json")))

        def fields = slurper.parseText(jsonFilter(new File(input, "field.json")))
        def catalogFile = new File(output, "index.md")
        def readme = new File(input, "README.md")
        def catalogOut = new StringWriter()
        catalogOut.println "- [系统介绍](index.md)"
        catalogOut.println ''
        def extraFiles = input.listFiles(new FileFilter() {
            @Override
            boolean accept(File pathname) {
                def name = pathname.name
                def accept = name.endsWith('.md') && name != 'README.md'
                if (accept) {
                    catalogOut.println "- [${name.replace('.md', '')}](${name})"
                }
                return accept
            }
        })
        catalogOut.println ''
        catalogOut.println '---'
        catalogOut.println ''
        trees.eachWithIndex() {
            tree, i ->
                i++
                def treeName = tree.text
                catalogOut.println "- [${i} ${treeName}](${treeName}.md)"
                catalogOut.println ''
                tree.children.eachWithIndex() {
                    leaf, m ->
                        m++
                        def leafName = leaf.text
                        catalogOut.println "\t- [${i}.${m} ${leafName}](${treeName}.md#${i}.${m}${leafName})"
                }
                catalogOut.println ''
                catalogOut.println '---'
        }
        def catalog = catalogOut.toString()
        catalogFile.withPrintWriter(encoding) { out ->
            printFile(out, catalog, {
                if (readme.exists()) {
                    out.println readme.text
                    out.println ''
                    out.println '---'
                }
            })
        }
        extraFiles.each { file ->
            new File(output, file.name).withPrintWriter(encoding) { out ->
                printFile(out, catalog, {
                    out.println file.text
                }
                )
            }
        }

        trees.eachWithIndex() {
            tree, i ->
                i++
                def treeName = tree.text
                new File(output, "${treeName}.md").withPrintWriter(encoding) { out ->
                    printFile(out, catalog, {
                        out.println "### ${i} ${treeName}"
                        out.println ''
                        tree.children.eachWithIndex() {
                            leaf, m ->
                                m++
                                def leafName = leaf.text
                                out.println "#### <a href='#${i}.${m}${leafName}' name='${i}.${m}${leafName}'>${i}.${m} ${leafName}</a>"
                                out.println ''
                                def api = apis.find({
                                    api ->
                                        api.resource == treeName && api.name == leafName
                                })
                                if (api == null)
                                    throw new Exception("未找到[${treeName}#${leafName}]接口")
                                out.println "###### 接口地址"
                                out.println ''
                                out.println "[${apiHost + api.url}](${apiHost + api.url})"
                                out.println ''
                                out.println "###### 请求方法"
                                out.println "${api.method}"
                                out.println ''
                                if (api.desc) {
                                    out.println "###### 说明"
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
                    })
                }
        }
    }

    static printFile(out, catalog, closure) {
        out.println "<div mdin class=\"catalog\">"
        out.println ''
        out.println catalog
        out.println "</div>"
        out.println "<div mdin class=\"content\">"
        out.println ''
        closure.call()
        out.println ''
        out.println "</div>"
        out.println "<div class=\"topAnchor\">\n" +
                "  <a href=\"#\">\n" +
                "    <span></span>\n" +
                "  </a>\n" +
                "</div>"
    }

    def fillDesc(out, api, fields, version) {
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
            out.println "###### 请求头参数"
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
            out.println "###### URL参数"
            out.println ''
            out.println "|名称|类型|描述|示例值|"
            out.println "|---|---|---|---|"
            uriVariables.eachWithIndex {
                it, index ->
                    out.println "| ${it.name} | ${it.type} | ${it.desc} | ${it.tempValue} |"
            }
        }
        out.println ''
        out.println "###### 请求参数"
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
        out.println "###### 响应参数"
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
            out.println "###### 响应示例"
            out.println ''
            out.println '```json'
            out.println StringEscapeUtils.unescapeJava(JsonOutput.prettyPrint(JsonOutput.toJson(convertResults(fields, results))))
            out.println '```'
        }
    }
/**
 * 转换结果示例
 * @param fields
 * @param results
 * @return
 */
    def convertResults(fields, results) {
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
    def getResultFields(fields, result) {
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
                field.tempValue = StringEscapeUtils.unescapeJava(JsonOutput.toJson(convertResults(fields, v)).replace('[', '\\['))
            else if (v instanceof Collection) {
                def list
                if (v.size() >= 1) {
                    v = v[0]
                    list = Collections.singletonList(v)
                } else {
                    list = []
                }
                field.tempValue = StringEscapeUtils.unescapeJava(JsonOutput.toJson(convertResults(fields, list)).replace('[', '\\['))
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
        if (value instanceof Collection)
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
        if (size > 1)
            throw new RuntimeException("id:${name}存在多个未区分属性说明：${StringEscapeUtils.unescapeJava(JsonOutput.toJson(result))}")
        if (size == 1) {
            origin = result[0]
        } else {
            def type = getFieldType(value)
            result = fields.findAll {
                if (!it.id && it.name == name && it.type.contains(type)) {
                    return it
                }
            }
            size = result.size()
            if (size > 1)
                throw new RuntimeException("name:${name},type:${type}存在多个未区分属性说明：${StringEscapeUtils.unescapeJava(JsonOutput.toJson(result))}")
            if (size == 1) {
                origin = result[0]
            } else {
                result = fields.findAll {
                    if (!it.id && it.name == name) {
                        return it
                    }
                }
                size = result.size()
                if (size > 1)
                    throw new RuntimeException("name:${name}存在多个未区分属性说明：${StringEscapeUtils.unescapeJava(JsonOutput.toJson(result))}")
                if (size == 1) {
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
/**
 * 过滤注释
 * @param file
 * @return
 */
    static jsonFilter(File file) {
        file.filterLine {
            !it.contains('//')
        }.toString()
    }
}