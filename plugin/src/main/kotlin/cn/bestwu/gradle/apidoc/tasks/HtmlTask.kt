package cn.bestwu.gradle.apidoc.tasks

import cn.bestwu.apidoc.ApidocExtension
import cn.bestwu.apidoc.HtmlGenerator
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 生成接口文档
 *
 * @author Peter Wu
 */
open class HtmlTask : DefaultTask() {

    @TaskAction
    fun run() {
        HtmlGenerator.call(project.extensions.findByType(ApidocExtension::class.java))
    }
}