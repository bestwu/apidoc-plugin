package cn.bestwu.gradle.apidoc.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.pegdown.Extensions
import org.pegdown.PegDownProcessor

/**
 * 生成接口文档
 *
 * @author Peter Wu
 */
class HtmlTask extends DefaultTask {

    @Input
    String encoding = 'UTF-8'
    @InputDirectory
    File input
    @OutputDirectory
    File output

    @TaskAction
    run() {
        if (!output.exists()) {
            output.mkdirs()
        }
        input.listFiles().each {
            markdown2html(it, new File(output, "${it.name}.html"))
        }
    }

    def markdown2html(inFile, outFile) {
        outFile.withPrintWriter(encoding) { out ->
            out.println new PegDownProcessor(Extensions.ALL_WITH_OPTIONALS).markdownToHtml(inFile.text.replace('.md', '.html'))
        }
    }

}