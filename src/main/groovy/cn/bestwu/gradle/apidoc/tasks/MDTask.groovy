package cn.bestwu.gradle.apidoc.tasks

import cn.bestwu.gradle.apidoc.support.MDGenerator
import cn.bestwu.gradle.apidoc.support.OrderedJsonParserUsingCharacterSource
import groovy.json.JsonSlurper
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
    @Input
    boolean cover = true

    @TaskAction
    run() {
        encoding = project.apidoc.encoding
        project.apidoc.paths.each { path ->
            def sourcePath = project.apidoc.sourcePath + '/' + path
            doMdTask(project.file(sourcePath), project.file(sourcePath + '/md'))
        }
    }

    def doMdTask(File input, File output) {
        if(cover){
            output.deleteDir()
        }
        if (!output.exists()) {
            output.mkdirs()
        }

        def slurper = new JsonSlurper()

        def trees = slurper.parseText(jsonFilter(new File(input, 'tree.json')))
        //        def apis = slurper.parseText(jsonFilter(new File(input, "api.json")))
        def apis = new OrderedJsonParserUsingCharacterSource().parse(jsonFilter(new File(input, "api.json")))

        def fields = slurper.parseText(jsonFilter(new File(input, "field.json")))

        trees.eachWithIndex() {
            tree, i ->
                i++
                def field = new File(input, "field/${tree.text}.json")
                def tempfields = []
                tempfields.addAll(fields)
                if (field.exists()) {
                    tempfields.addAll(slurper.parseText(jsonFilter(field)))
                }
                MDGenerator.generate(i, tree, apis, tempfields, output, apiHost, cover, encoding)

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