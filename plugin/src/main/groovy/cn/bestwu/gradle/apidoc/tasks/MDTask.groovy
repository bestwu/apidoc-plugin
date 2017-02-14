package cn.bestwu.gradle.apidoc.tasks

import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap
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
                    out.println ''
                    out.println '---'
            }
        }
        trees.eachWithIndex() {
            tree, i ->
                i++
                def treeName = tree.text
                new File(mdOutput, "${treeName}.md").withPrintWriter(encoding) { out ->
                    out.println "### ${i} ${treeName}"
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
        }


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
            out.println ""
            out.println "###### URL参数"
            out.println ""
            out.println "|名称|类型|最大长度|描述|示例值|"
            out.println "|---|---|---|---|---|"
            urlParams.eachWithIndex {
                it, index ->
                    out.println "| ${it.name} | ${it.type} | ${it.length} | ${it.desc} | ${it.tempValue} |"
            }
        }
        out.println "###### 请求参数"
        out.println ""

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
        out.println ""

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

                    if (v == null || '' == v) {
                        field.tempValue = field.value
                    } else {
                        field.tempValue = v
                        if (v.getClass() == LazyMap.class)
                            flds.addAll(getFields(fields, v))
                    }
                    if (field.length == null)
                        field.length = '-'
                    field.length = '-' == field.length ? '\\-' : field.length
                    flds.add(field)
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