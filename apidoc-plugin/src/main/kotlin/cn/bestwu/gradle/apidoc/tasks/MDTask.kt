package cn.bestwu.gradle.apidoc.tasks

import cn.bestwu.apidoc.ApidocExtension
import cn.bestwu.apidoc.MDGenerator
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 生成接口文档
 *
 * @author Peter Wu
 */
open class MDTask : DefaultTask() {

    @TaskAction
    fun run() {
        MDGenerator.call(project.extensions.findByType(ApidocExtension::class.java)!!)
    }


}