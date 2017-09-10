package cn.bestwu.gradle.apidoc

import cn.bestwu.apidoc.ApidocExtension
import cn.bestwu.gradle.apidoc.tasks.HtmlTask
import cn.bestwu.gradle.apidoc.tasks.MDTask
import org.gradle.api.Plugin
import org.gradle.api.Project
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
            val apidocExtension = project.extensions.findByType(ApidocExtension::class.java)
            project.tasks.create("mddoc", MDTask::class.java) {
                apidocExtension.paths.forEach { path ->
                    val sourcePath = apidocExtension.sourcePath + "/" + path
                    val inputDir = project.file(sourcePath)!!
                    val outputDir = project.file(sourcePath + "/md")
                    if (!outputDir.exists())
                        outputDir.mkdirs()
                    it.inputs.files(inputDir.listFiles { file: File ->
                        file != outputDir && file != project.file(sourcePath + "/html")
                    })
                    it.outputs.dir(outputDir)
                }
                it.cover = apidocExtension.cover
                it.apiHost = if (apidocExtension.apiHost == "") apidocExtension.defaultHost else apidocExtension.apiHost
            }
            project.tasks.create("htmldoc", HtmlTask::class.java) {
                it.dependsOn("mddoc")
                apidocExtension.paths.forEach { path ->
                    val sourcePath = apidocExtension.sourcePath + "/" + path
                    it.inputs.dir(sourcePath + "/md")
                    it.inputs.files(project.file(sourcePath).listFiles { file: File ->
                        file.name.endsWith(".md")
                    })
                    it.outputs.dir(sourcePath + "/html")
                }
            }
            project.tasks.create("alphaMddoc", MDTask::class.java) {
                apidocExtension.paths.forEach { path ->
                    val sourcePath = apidocExtension.sourcePath + "/" + path
                    val inputDir = project.file(sourcePath)
                    val outputDir = project.file(sourcePath + "/md")
                    it.inputs.files(inputDir.listFiles { file: File ->
                        file != outputDir && file != project.file(sourcePath + "/html")
                    })
                    it.outputs.dir(outputDir)
                }
                it.cover = apidocExtension.cover
                it.apiHost = apidocExtension.defaultHost
            }
            project.tasks.create("alphaHtmldoc", HtmlTask::class.java) {
                it.dependsOn("mddoc")
                apidocExtension.paths.forEach { path ->
                    val sourcePath = apidocExtension.sourcePath + "/" + path
                    it.inputs.dir(sourcePath + "/md")
                    it.inputs.files(project.file(sourcePath).listFiles { file: File ->
                        file.name.endsWith(".md")
                    })
                    it.outputs.dir(sourcePath + "/html")
                }
                it.doFirst {
                    (project.tasks.findByPath("alphaMddoc") as MDTask).execute()
                }
            }
        }
    }
}