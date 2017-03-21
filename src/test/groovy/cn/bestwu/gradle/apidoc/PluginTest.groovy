package cn.bestwu.gradle.apidoc

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.json.StringEscapeUtils
import org.junit.Test

/**
 * @author Peter Wu
 */
class PluginTest {

    @Test
    void test() throws Exception {
//        Project project = ProjectBuilder.builder().build()
//        def apidocPlugin = new ApidocPlugin()
//        project.plugins.add(apidocPlugin)
//        project.apidoc {
//            apiHost 'http://127.0.0.1'
//        }
//        println project.tasks
//        assertTrue(project.htmldoc instanceof HtmlTask)
    }

    @Test
    void convertFields() throws Exception {
        def file = new File("D:\\Repositories\\bestwu\\apidoc-plugin\\sample\\src\\main\\resources\\_t\\field.json")
        def json = new JsonSlurper().parseText(jsonFilter(file))
        json.each { k, get ->
            get.type = get.length != null && get.length != '-' ? "${get.type.capitalize()}(${get.length})" : get.type.capitalize()
            get.remove('length')
        }
        file.withPrintWriter('UTF-8') { out ->
            out.println StringEscapeUtils.unescapeJava(JsonOutput.prettyPrint(JsonOutput.toJson(json)))
        }
    }

    static jsonFilter(File file) {
        file.filterLine {
            !it.contains('//')
        }.toString()
    }
}
