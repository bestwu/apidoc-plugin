package cn.bestwu.gradle.apidoc

import cn.bestwu.apidoc.ApidocExtension
import cn.bestwu.gradle.apidoc.tasks.HtmlTask
import cn.bestwu.gradle.apidoc.tasks.MDTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.language.jvm.tasks.ProcessResources
import java.io.File

/**
 *
 * 注册task
 *
 * @author Peter Wu
 */
class ApidocPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create("apidoc", ApidocExtension::class.java)

        project.afterEvaluate {
            val apidocExtension = project.extensions.findByType(ApidocExtension::class.java)!!
            if (apidocExtension.projectName.isBlank()) {
                apidocExtension.projectName = project.name
            }
            val docOutputDir = (project.tasks.getByName("processResources") as ProcessResources).destinationDir.absolutePath
            if (apidocExtension.output == apidocExtension.sourcePath)
                apidocExtension.output = docOutputDir
            project.tasks.create("mddoc", MDTask::class.java) {
                apidocExtension.paths.forEach { path ->
                    val sourcePath = apidocExtension.sourcePath + "/" + path
                    val inputDir = project.file(sourcePath)
                    val outputDir = File("$docOutputDir/$path", "$sourcePath/md")
                    if (inputDir.exists()) {
                        it.inputs.dir(inputDir)
                    }
                    if (outputDir.exists())
                        it.outputs.dir(outputDir)
                }
            }
            project.tasks.create("htmldoc", HtmlTask::class.java) {
                it.dependsOn("mddoc")
                apidocExtension.paths.forEach { path ->
                    val sourcePath = apidocExtension.sourcePath + "/" + path
                    val inputDir = project.file(sourcePath)
                    val outputDir = File("$docOutputDir/$path", "$sourcePath/html")
                    if (inputDir.exists()) {
                        it.inputs.dir(inputDir)
                    }
                    if (outputDir.exists())
                        it.outputs.dir(outputDir)
                }
            }
        }
    }
}