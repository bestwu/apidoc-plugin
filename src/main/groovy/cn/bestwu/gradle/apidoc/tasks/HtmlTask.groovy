package cn.bestwu.gradle.apidoc.tasks

import cn.bestwu.gradle.apidoc.support.HtmlGenerator
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jsoup.Jsoup
import org.pegdown.*
import org.pegdown.ast.RootNode
import org.pegdown.ast.TableCellNode
import org.pegdown.ast.TableColumnNode
import org.pegdown.ast.TextNode
import org.pegdown.plugins.ToHtmlSerializerPlugin

/**
 * 生成接口文档
 *
 * @author Peter Wu
 */
class HtmlTask extends DefaultTask {

    String encoding

    @TaskAction
    run() {
        encoding = project.apidoc.encoding
        project.apidoc.paths.each { path ->
            def sourcePath = project.apidoc.sourcePath + '/' + path
            HtmlGenerator.generate(project.file(sourcePath), project.file(sourcePath + '/html'),encoding)
        }
    }
}