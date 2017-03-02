package cn.bestwu.gradle.apidoc.tasks

import cn.bestwu.gradle.apidoc.support.OrderedJsonParserUsingCharacterSource
import groovy.json.JsonSlurper
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
/**
 * 生成接口文档
 *
 * @author Peter Wu
 */
class MDTask extends DefaultTask {

    @Input
    String encoding = 'UTF-8'
    @Input
    String apiHost = ''
    File input
    @OutputDirectory
    File output

    @TaskAction
    run() {
        def mdOutput = output
        if (!mdOutput.exists()) {
            mdOutput.mkdirs()
        }
        def slurper = new JsonSlurper()

        def trees = slurper.parseText(jsonFilter(new File(input, 'tree.json')))
        //        def apis = slurper.parseText(jsonFilter(new File(input, "api.json")))
        def apis = new OrderedJsonParserUsingCharacterSource().parse(jsonFilter(new File(input, "api.json")))

        def fields = slurper.parseText(jsonFilter(new File(input, "field.json")))
        def catalogFile = new File(mdOutput, "index.md")
        def readme = new File(input, "README.md")
        def catalogOut = new StringWriter()
        catalogOut.println "- [文档首页](index.md)"
        catalogOut.println ''
        readme.readLines().forEach({ it ->
            if (it.startsWith('### ')) {
                def name = it.replace('### ', '').trim()
                catalogOut.println "\t- [${name}](index.md#${name.replace(' ', '-')})"
            }
        })
        def extraFiles = input.listFiles(new FileFilter() {
            @Override
            boolean accept(File pathname) {
                def name = pathname.name
                def accept = name.endsWith('.md') && name != 'README.md'
                if (accept) {
                    catalogOut.println "\t- [${name.replace('.md', '')}](${name})"
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
        extraFiles.each { file ->
            new File(mdOutput, file.name).withPrintWriter(encoding) { out ->
                printFile(out, catalog, {
                    out.println file.text
                }
                )
            }
        }
        catalogFile.withPrintWriter(encoding) { out ->
            printFile(out, catalog, {
                if (readme.exists()) {
                    out.println readme.text
                    out.println ''
                    out.println '---'
                }
            })
        }

        trees.eachWithIndex() {
            tree, i ->
                i++
                def treeName = tree.text
                new File(mdOutput, "${treeName}.md").withPrintWriter(encoding) { out ->
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
                                        api.resourceType == treeName && api.name == leafName
                                })
                                out.println "###### 接口地址"
                                out.println ''
                                out.println "[${apiHost + api.url}](${apiHost + api.url})"
                                out.println ''
                                out.println "###### 请求方法"
                                out.println "${api.httpMethod}"
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
        out.println "<div mdin style=\"float: left;width:25%;background-color: #f7f5fa;\">"
        out.println ''
        out.println catalog
        out.println "</div>"
        out.println "<div mdin style=\"float: left;width:74%;margin-left: 1%;\">"
        out.println ''
        closure.call()
        out.println ''
        out.println "</div>"
        out.println "<div style=\"display:block;position:fixed;z-index:1001;bottom:10px;right:0;margin:0;padding:0;background-color:#c9c9c9\">\n" +
                "  <a style=\"display:block;padding:12px;background:rgba(255,255,255,.5);\" href=\"#\">\n" +
                "    <span style=\"display:block;width:33px;height:24px;\">TOP</span>\n" +
                "  </a>\n" +
                "</div>"
    }

    def fillDesc(out, api, fields, version) {
        def urlParams = api.urlParams
        def params = api.params
        def results = api.results
        if (version && '1.0' != version && api[version]) {
            if (api[version].urlParams)
                urlParams = api[version].urlParams
            if (api[version].params)
                params = api[version].params
            if (api[version].results)
                results = api[version].results
        }

        urlParams = getFields(fields, urlParams)
        if (urlParams != null && !urlParams.isEmpty()) {
            out.println ''
            out.println "###### URL参数"
            out.println ''
            out.println "|名称|类型|最大长度|描述|示例值|"
            out.println "|---|---|---|---|---|"
            urlParams.eachWithIndex {
                it, index ->
                    out.println "| ${it.name} | ${it.type} | ${it.length} | ${it.desc} | ${it.tempValue} |"
            }
        }
        out.println "###### 请求参数"
        out.println ''

        params = getFields(fields, params)
        if (params == null || params.isEmpty()) {
            out.println "无"
        } else {
            out.println "|名称|类型|是否必填|最大长度|描述|默认值|示例值|"
            out.println "|---|---|---|---|---|---|---|"
            params.each {
                out.println "| ${it.name} | ${it.type} | ${it.notNullDesc} | ${it.length} | ${it.desc} | ${it.value} | ${it.tempValue} |"
            }
        }
        out.println "###### 响应参数"
        out.println ''

        results = getFields(fields, results)
        if (results == null || results.isEmpty()) {
            out.println "无"
        } else {
            out.println "|名称|类型|最大长度|描述|示例值|"
            out.println "|---|---|---|---|---|"
            results.each {
                out.println "| ${it.name} | ${it.type} | ${it.length} | ${it.desc} | ${it.tempValue} |"
            }
        }
    }


    def getFields(fields, key) {
        if (!key)
            return null
        def keyClass = key.class
        switch (keyClass) {
            case String.class:
                if ('' == key) {
                    return []
                }
                def params = key.split('&')
                def paramsObj = new HashMap()
                params.each {
                    def kv = it.split('=')
                    if (kv.length == 2) {
                        paramsObj.put(kv[0], kv[1])
                    } else {
                        paramsObj.put(it, kv[1])
                    }
                }
                return getFields(fields, paramsObj)
            case ArrayList.class:
                def flds = []
                for (def i = 0; i < key.size(); i++) {
                    def item = key[i]
                    flds = flds.addAll(fields, getFields(item))
                }
                key = flds
                break
            default:
                def flds = []
                key.each { k, v ->
                    def notNull = null, name
                    if (k.endsWith('&')) {
                        notNull = true
                        name = k.substring(0, k.length() - 1)
                    } else if (k.endsWith('^')) {
                        notNull = false
                        name = k.substring(0, k.length() - 1)
                    } else {
                        name = k
                    }

                    def field = fields[name]
                    if (field == null) {
                        field = [name: name]
                    }
                    if (notNull == null) {
                        notNull = field.notNull
                    }
                    field.notNullDesc = notNull ? '是' : '否'

                    if (v == null || '' == v || ((v instanceof Map || v instanceof Collection) && v.size() == 0)) {
                        field.tempValue = field.value
                    } else {
                        field.tempValue = v
                    }
                    if (field.length == null)
                        field.length = '-'
                    field.length = '-' == field.length ? '\\-' : field.length
                    flds.add(field)
                    if (v instanceof Map && v.size() > 0) {
                        flds.addAll(getFields(fields, v))
                    }
                }
                key = flds
                break
        }
        return key
    }

    static jsonFilter(File file) {
        file.filterLine {
            !it.contains('//')
        }.toString()
    }
}