package cn.bestwu.gradle.apidoc.tasks

import groovy.json.JsonSlurper
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
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
    @InputDirectory
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
        def apis = slurper.parseText(jsonFilter(new File(input, "api.json")))
        def fields = slurper.parseText(jsonFilter(new File(input, "field.json")))
        new File(mdOutput, "index.md").withPrintWriter(encoding) { out ->
            trees.eachWithIndex() {
                tree, i ->
                    i++
                    def treeName = tree.text
                    out.println "### [${i}.${treeName}](${treeName}.md)"
                    out.println ""
                    tree.children.eachWithIndex() {
                        leaf, m ->
                            m++
                            def leafName = leaf.text
                            out.println "#### [${i}.${m} ${leafName}](${treeName}.md#${i}.${m}${leafName})"
                    }
            }
        }
        trees.eachWithIndex() {
            tree, i ->
                i++
                def treeName = tree.text
                new File(mdOutput, "${treeName}.md").withPrintWriter(encoding) { out ->
                    out.println " ### ${i}.${treeName}"
                    out.println ""
                    tree.children.eachWithIndex() {
                        leaf, m ->
                            m++
                            def leafName = leaf.text
                            out.println "#### <a href='#${i}.${m}${leafName}' name='${i}.${m}${leafName}'>${i}.${m} ${leafName}</a>"
                            out.println ""
                            def api = apis.find({
                                api ->
                                    api.resourceType == treeName && api.name == leafName
                            })
                            out.println "###### 接口地址"
                            out.println ""
                            out.println "[${apiHost + api.url}](${apiHost + api.url})"
                            out.println ""
                            out.println "###### 请求方法"
                            out.println "${api.httpMethod}"
                            out.println ""
                            def urlParams = api.urlParams
                            if (urlParams != null && !urlParams.isEmpty()) {
                                out.println ""
                                out.println "###### URL上的参数说明"
                                out.println ""
                                out.println "|参数序号|参数说明|"
                                out.println "|---|---|"
                                printUrlParams(out, fields, urlParams)
                            }
                            out.println "###### 请求参数说明"
                            out.println ""
                            def params = api.params
                            if (params.isEmpty()) {
                                out.println "无"
                            } else {
                                out.println "|参数名称|值描述|是否可空|限制长度|参数类型|"
                                out.println "|---|---|---|---|---|"
                                params.each {
                                    field ->
                                        printParams(out, fields, field)
                                }
                            }

                            out.println "###### 响应字段说明"
                            out.println ""
                            def results = api.results
                            if (results.isEmpty()) {
                                out.println "无"
                            } else {
                                out.println "|名称|值描述|限制长度|参数类型|"
                                out.println "|---|---|---|---|"
                                results.each {
                                    field ->
                                        printResult(out, fields, field)
                                }
                            }
                    }
                }
        }


    }

    def printUrlParams(out, fields, key) {
        def keyClass = key.class
        switch (keyClass) {
            case String.class:
                getFields(fields, key).eachWithIndex {
                    p, i ->
                        out.println "| ${i} | ${p.desc} |"
                }
                break
            case ArrayList.class:
                key.each {
                    getFields(fields, it).eachWithIndex {
                        p, i ->
                            out.println "| ${i} | ${p.desc} |"
                    }
                }
                break
        }

    }

    def printParams(out, fields, key) {
        getFields(fields, key).each {
            out.println "| ${it.name} | ${it.desc} | ${it.optional ? '是' : '否'} | 无 | ${it.type} |"
        }
    }

    def printResult(out, fields, key) {
        getFields(fields, key).each {
            out.println "| ${it.name} | ${it.desc} | ${it.optional ? '是' : '否'} | ${it.type} |"
        }
    }

    def getFields(fields, key) {
        def keyClass = key.class
        switch (keyClass) {
            case String.class:
                def field = fields[key]
                if (!field) {
                    field = [name: key, desc: '']
                }
                return getFields(fields, field)
            case ArrayList.class:
                def newkey = []
                key.each {
                    it ->
                        newkey.addAll(getFields(fields, it))
                }
                key = newkey
                break
            default:
                def ftype = key['ftype']
                if (ftype) {
                    def field = fields[ftype]
                    if (!field) {
                        field = [name: key, desc: '']
                    }
                    key['value'] = key['value'] == null ? field['value'] : null
                    key['name'] = key['name'] == null ? field['name'] : null
                    key['store'] = key['store'] == null ? field['store'] : null
                    key['type'] = key['type'] == null ? field['type'] : null
                    key['optional'] = key['optional'] == null ? field['optional'] : key['optional']
                    key['desc'] = key['desc'] == null ? field['desc'] : null
                    key.children = key.children.contains(null) ? field.children : key.children
                }
                key = [key]
                def children = key.children
                children.remove(null)
                if (children != null && !children.isEmpty()) {
                    key.addAll(getFields(fields, children))
                }
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