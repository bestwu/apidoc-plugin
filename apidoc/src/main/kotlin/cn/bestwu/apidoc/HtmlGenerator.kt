package cn.bestwu.apidoc

import org.pegdown.*
import org.pegdown.ast.AnchorLinkNode
import org.pegdown.ast.TableCellNode
import org.pegdown.ast.TextNode
import org.pegdown.plugins.PegDownPlugins
import org.pegdown.plugins.ToHtmlSerializerPlugin
import java.io.File
import java.io.StringWriter


/**
 * 生成接口文档
 *
 * @author Peter Wu
 */
object HtmlGenerator {

    fun call(apidocExtension: ApidocExtension) {
        apidocExtension.paths.forEach {
            val sourcePath = apidocExtension.sourcePath + "/" + it
            val input = File(sourcePath)
            if (input.exists()) {
                val extraFiles = input.listFiles { file: File ->
                    file.name.endsWith(".md")
                }
                call(apidocExtension, File(input, "md"), File(input, "html"), *extraFiles)
            }
        }
    }

    private fun call(apidocExtension: ApidocExtension, input: File, output: File, vararg extraFiles: File) {
        output.deleteRecursively()
        if (!output.exists()) {
            output.mkdirs()
        }

        val readme = extraFiles.find { it.name == "README.md" }
        val catalogOut = StringWriter()
        val projectName = apidocExtension.projectName
        if (projectName.isNotBlank()) {
            catalogOut.appendln("# $projectName #")
            catalogOut.appendln("")
        }
        if (readme != null)
            catalogOut.appendln("- [系统介绍](index.html)")
        catalogOut.appendln("")
        extraFiles.forEach { file ->
            val name = file.name
            if (name != "README.md")
                catalogOut.appendln("- [${name.replace(".md", "")}](${name.replace(".md", ".html")})")
        }
        catalogOut.appendln("")
        catalogOut.appendln("---")
        catalogOut.appendln("")

        val listOfFiles= mutableListOf<File>()
        if (input.exists()) {
            val files = input.listFiles()
            files.sort()
            listOfFiles.addAll(files)
            files.forEach {
                val fileName = it.name.replace(".md", "")
                val link = getAnchor(fileName).replace(Regex("^0?(.*)$"), "$1")
                catalogOut.appendln("- [${fileName.replace(Regex("^0?(.*)$"), "$1").replace("-", " ")}]($fileName.html#$link)")
//            catalogOut.appendln("- <a href=\"${fileName}.html#$link\" name=\"$link\">${fileName.replace(/^0?(.*)$/, "$1").replace("-", " ")}</a>")
                catalogOut.appendln("")
                it.forEachLine { l ->
                    val reg = Regex("^ *(#+).*#?$")
                    if (l.matches(reg) && l.replace(reg, "$1").length <= 4) {
                        val name = l.replace(Regex("^ *#+ *(.*?) *#*$"), "$1")
                        if (name != fileName.replace(Regex("^0?(.*)$"), "$1").replace("-", " ")) {
                            catalogOut.appendln("\t- [$name]($fileName.html#${getAnchor(name)})")
//                        catalogOut.appendln("\t- <a href=\"${fileName}.html#${name.toLowerCase().replace(".", "-").replace(" ", "-")}\" name=\"${name.toLowerCase().replace(".", "-").replace(" ", "-")}\">$name</a>")
                        }
                    }
                }
                catalogOut.appendln("")
                catalogOut.appendln("---")
            }
        }

        val catalog = catalogOut.toString()

        listOfFiles.addAll(extraFiles)
        listOfFiles.forEach {
            markdown2html(catalog, it, File(output, "${if (it.name == "README.md") "index" else it.name.replace(".md", "")}.html"))
        }
    }

    private fun getAnchor(name: String): String = AnchorLinkNode(name).name

    private fun markdown2html(catalog: String, inFile: File, outFile: File) {
        val fileName = inFile.name.replace(".md", "")
        var title = fileName.replace(Regex("^0?(.*)$"), "$1").replace("-", " ")
        if ("README" == title) {
            title = "接口文档"
        }
        val catalogHtml = PegDownProcessor(Extensions.ALL_WITH_OPTIONALS xor Extensions.SMARTYPANTS).markdownToHtml(catalog)
        val content = MdProcessor(Extensions.ALL_WITH_OPTIONALS xor Extensions.SMARTYPANTS).markdownToHtml(inFile.readText().replace(".md", ".html"))
        val anchor = "$fileName.html#${fileName.toLowerCase().replace(Regex("^0?(.*)$"), "$1")}"
        outFile.writeText(HtmlGenerator::class.java.getResource("/template.html").readText().format(title, catalogHtml, content, anchor))
        println("生成：$outFile")
    }


    class MdProcessor(options: Int) : PegDownProcessor(options, PegDownProcessor.DEFAULT_MAX_PARSING_TIME, PegDownPlugins.NONE) {

        override fun markdownToHtml(markdownSource: CharArray?, linkRenderer: LinkRenderer?, verbatimSerializerMap: MutableMap<String, VerbatimSerializer>?, plugins: MutableList<ToHtmlSerializerPlugin>?): String? {
            try {
                val astRoot = parseMarkdown(markdownSource)
                return object : ToHtmlSerializer(linkRenderer, verbatimSerializerMap, plugins) {
                    override fun visit(node: TableCellNode) {
                        val me = this
                        val tag = if (me.inTableHeader) "th" else "td"
                        val columns = me.currentTableNode.columns
                        val column = columns[Math.min(me.currentTableColumn, columns.size - 1)]

                        me.printer.println().print("<").print(tag).print(" title=\"")
                        var titleText = ""
                        node.children.filter { it is TextNode }.forEach {
                            titleText += (it as TextNode).text.replace("\"", "&quot;")
                        }
                        me.printer.print(titleText)
                        me.printer.print("\"")
                        column.accept(me)
                        if (node.colSpan > 1) me.printer.print(" colspan=\"").print(Integer.toString(node.colSpan)).print("\"")
                        me.printer.print(">")
                        visitChildren(node)
                        me.printer.print("<").print("/").print(tag).print(">")

                        me.currentTableColumn += node.colSpan
                    }
                }.toHtml(astRoot)
            } catch (ignored: ParsingTimeoutException) {
                return null
            }
        }
    }
}