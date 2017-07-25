package cn.bestwu.gradle.apidoc.tasks

import cn.bestwu.gradle.apidoc.support.HtmlGenerator
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

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
            def input = project.file(sourcePath)
            def extraFiles = input.listFiles(new FileFilter() {
                @Override
                boolean accept(File file) {
                    return file.name.endsWith('.md')
                }
            })
            HtmlGenerator.generate(new File(input, 'md'), project.file(sourcePath + '/html'), encoding, extraFiles)
        }
    }
}