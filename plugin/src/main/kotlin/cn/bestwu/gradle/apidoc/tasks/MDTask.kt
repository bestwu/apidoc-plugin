package cn.bestwu.gradle.apidoc.tasks

import cn.bestwu.apidoc.ApidocExtension
import cn.bestwu.apidoc.MDGenerator
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * 生成接口文档
 *
 * @author Peter Wu
 */
open class MDTask : DefaultTask() {
    var apiHost: String = ""
    var cover = true

    @TaskAction
    fun run() {
        val apidocExtension = project.extensions.findByType(ApidocExtension::class.java)

        apidocExtension.paths.forEach { path ->
            val sourcePath = apidocExtension.sourcePath + "/" + path
            doMdTask(project.file(sourcePath), project.file(sourcePath + "/md"))
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun doMdTask(input: File, output: File) {
        if (cover) {
            output.deleteRecursively()
        }
        if (!output.exists()) {
            output.mkdirs()
        }

        val parser = Parser()
        val trees = parser.parse(File(input, "tree.json").inputStream()) as JsonArray<JsonObject>
        val apis = parser.parse(File(input, "api.json").inputStream()) as JsonArray<JsonObject>
        val fields = parser.parse(File(input, "field.json").inputStream()) as JsonArray<JsonObject>

        trees.forEachIndexed { i, tree ->
            val field = File(input, "field/${tree["text"]}.json")
            val tempfields = JsonArray<JsonObject>()
            tempfields.addAll(fields)
            if (field.exists()) {
                tempfields.addAll(parser.parse(field.inputStream()) as JsonArray<JsonObject>)
            }
            MDGenerator.generate(tree, apis, tempfields, output, apiHost, cover, i + 1)

        }
    }

}