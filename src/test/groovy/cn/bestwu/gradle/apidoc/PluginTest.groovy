package cn.bestwu.gradle.apidoc

import cn.bestwu.gradle.apidoc.tasks.MDTask
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
        def l = '#### 响应参数 ####', reg = / *(#+).*#?/
        System.err.println(l.matches(reg))
        System.err.println(l.replaceAll(reg, '$1').length())
        System.err.println(l.replaceAll(/ *#+ *(.*?) *#*/, '$1'))
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
    void findField() throws Exception {
        def file = new File("D:\\Repositories\\bestwu\\apidoc-plugin\\sample\\src\\main\\resources\\_t\\field.json")
        def json = new JsonSlurper().parseText(jsonFilter(file))
        System.err.println(MDTask.findField(json, 'note', 'String'))
    }

    @Test
    void convertFields() throws Exception {
        def file = new File("D:\\Repositories\\bestwu\\apidoc-plugin\\sample\\src\\main\\resources\\_t\\field.json")
        def json = new JsonSlurper().parseText(jsonFilter(file))
        def j = []
        json.each { k, get ->
            get.type = get.length != null && get.length != '-' ? "${get.type.capitalize()}(${get.length})" : get.type.capitalize()
            get.remove('length')
            get.id = k

            j.add(get)
        }
        file.withPrintWriter('UTF-8') { out ->
            out.println StringEscapeUtils.unescapeJava(JsonOutput.prettyPrint(JsonOutput.toJson(j)))
        }
    }

    static jsonFilter(File file) {
        file.filterLine {
            !it.contains('//')
        }.toString()
    }
}
