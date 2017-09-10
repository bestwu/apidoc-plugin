package cn.bestwu.gradle.apidoc.tasks

import cn.bestwu.apidoc.ApidocExtension
import cn.bestwu.apidoc.HtmlGenerator
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * 生成接口文档
 *
 * @author Peter Wu
 */
open class HtmlTask : DefaultTask() {

    @TaskAction
    fun run() {
        val apidocExtension = project.extensions.findByType(ApidocExtension::class.java)

        apidocExtension.paths.forEach {
            val sourcePath = apidocExtension.sourcePath + "/" + it
            val input = project.file(sourcePath)
            val extraFiles = input.listFiles { file: File ->
                file.name.endsWith(".md")
            }
            HtmlGenerator.generate(File(input, "md"), project.file(sourcePath + "/html"), *extraFiles)
        }
    }
}