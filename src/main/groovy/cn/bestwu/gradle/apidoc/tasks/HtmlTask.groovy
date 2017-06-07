package cn.bestwu.gradle.apidoc.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jsoup.Jsoup
import org.pegdown.*
import org.pegdown.ast.*
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
            doHtmlTask(project.file(sourcePath + '/md'), project.file(sourcePath + '/html'))
        }
    }

    def doHtmlTask(File input, File output) {
        if (!output.exists()) {
            output.mkdirs()
        }
        new File(output, 'apidoc.css').withPrintWriter(encoding) { out ->
            out.print HtmlTask.class.getClassLoader().getResource("apidoc.css").text
        }
        input.listFiles().each {
            markdown2html(it, new File(output, "${it.name}.html".replace('.md', '')))
        }
    }

    def markdown2html(inFile, outFile) {
        def title = inFile.name.replace('.md', '')
        if ('index' == title) {
            title = '接口文档'
        }
        def header = '<!DOCTYPE html>\n' +
                '<html>\n' +
                '<head>\n' +
                '  <meta charset="UTF-8"/>\n' +
                '  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>\n' +
                '  <meta name="renderer" content="webkit"/>\n' +
                '  <meta name="apple-touch-fullscreen" content="yes"/>\n' +
                '  <meta name="apple-mobile-web-app-capable" content="yes"/>\n' +
                '  <meta name="viewport" content="width=device-width, initial-scale=1"/>\n' +
                '  <title>' + title + '</title>\n' +
                '  <link rel="stylesheet" type="text/css" href="apidoc.css"/>' +
                '</head>\n' +
                '<body>\n'
        def footer = '\n</body>\n' +
                '</html>'
        outFile.withPrintWriter(encoding) { out ->
            out.println header + new PegDownProcessor(Extensions.ALL_WITH_OPTIONALS ^ Extensions.SMARTYPANTS) {
                String markdownToHtml(char[] markdownSource,
                                      LinkRenderer linkRenderer,
                                      Map<String, VerbatimSerializer> verbatimSerializerMap,
                                      List<ToHtmlSerializerPlugin> plugins) {
                    try {
                        def processor = this
                        RootNode astRoot = parseMarkdown(markdownSource)
                        return new ToHtmlSerializer(linkRenderer, verbatimSerializerMap, plugins) {
                            void visit(TableCellNode node) {
                                String tag = inTableHeader ? "th" : "td"
                                List<TableColumnNode> columns = currentTableNode.getColumns()
                                TableColumnNode column = columns.get(Math.min(currentTableColumn, columns.size() - 1))

                                def titleText = ''
                                node.getChildren().each {
                                    if (it instanceof TextNode)
                                        titleText += Jsoup.parse(it.text).text().replace('\"', '&quot;')
                                }
                                printer.println().print('<').print(tag).print(' title=\"').print(titleText).print("\"")
                                column.accept(this)
                                if (node.getColSpan() > 1) printer.print(" colspan=\"").print(Integer.toString(node.getColSpan())).print('"')
                                printer.print('>')
                                visitChildren(node)
                                printer.print('<').print('/').print(tag).print('>')

                                currentTableColumn += node.getColSpan()
                            }

                            void visit(HtmlBlockNode node) {
                                String text = node.getText()
                                if (text.length() > 0) {
                                    printer.println()
                                    if (text.matches('^<div mdin .*?>(\\s.*\\s*)*?</div>$')) {
                                        String content = text.replaceAll('^<div mdin .*?>((\\s.*\\s*)*?)</div>$', '$1')
                                        String tagopen = text.replaceAll('^(<div mdin .*?>)(\\s.*\\s*)*?</div>$', '$1')
                                        String tagclose = '</div>'
                                        printer.print(tagopen)
                                        visit(processor.parseMarkdown(content.toCharArray()))
                                        printer.print(tagclose)
                                    } else {
                                        printer.print(text)
                                    }
                                }
                            }
                        }.toHtml(astRoot)
                    } catch (ParsingTimeoutException ignored) {
                        return null
                    }
                }
            }.markdownToHtml(inFile.text.replace('.md', '.html')) + footer
        }
    }

}