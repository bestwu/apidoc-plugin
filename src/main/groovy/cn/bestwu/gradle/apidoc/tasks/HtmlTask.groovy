package cn.bestwu.gradle.apidoc.tasks

import groovy.json.JsonSlurper
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
            doHtmlTask(project.file(sourcePath), project.file(sourcePath + '/html'))
        }
    }

    def doHtmlTask(File input, File output) {
        if (!output.exists()) {
            output.mkdirs()
        }
        def mddir = new File(input, 'md')

        def slurper = new JsonSlurper()

        def trees = slurper.parseText(jsonFilter(new File(input, 'tree.json')))
        def catalogFile = new File(mddir, "index.md")
        def readme = new File(input, "README.md")
        def catalogOut = new StringWriter()
        if (readme.exists())
            catalogOut.println "- [系统介绍](index.html)"
        catalogOut.println ''
        def extraFiles = input.listFiles(new FileFilter() {
            @Override
            boolean accept(File pathname) {
                def name = pathname.name
                def accept = name.endsWith('.md') && name != 'README.md'
                if (accept) {
                    catalogOut.println "- [${name.replace('.md', '')}](${name.replace('.md', '.html')})"
                }
                return accept
            }
        })
        catalogOut.println ''
        catalogOut.println '---'
        catalogOut.println ''
        trees.eachWithIndex() {
            tree, i ->
                i++
                def treeName = tree.text
                catalogOut.println "- [${i} ${treeName}](${treeName}.html)"
                catalogOut.println ''
                tree.children.eachWithIndex() {
                    leaf, m ->
                        m++
                        def leafName = leaf.text
                        catalogOut.println "\t- [${i}.${m} ${leafName}](${treeName}.html#${i}-${m}-${leafName})"
                }
                catalogOut.println ''
                catalogOut.println '---'
        }
        def catalog = catalogOut.toString()
        if (readme.exists()) {
            catalogFile.withPrintWriter(encoding) { out ->
                out.println readme.text
                out.println ''
                out.println '---'
            }
        }
        extraFiles.each { file ->
            new File(mddir, file.name).withPrintWriter(encoding) { out ->
                out.println file.text
            }
        }
        mddir.listFiles().each {
            markdown2html(catalog, it, new File(output, "${it.name}.html".replace('.md', '')))
        }
    }

    def markdown2html(catalog, inFile, outFile) {
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
                '  <style type="text/css">\n' +
                '    body {\n' +
                '      margin: 0;\n' +
                '      left: 0;\n' +
                '      top: 0;\n' +
                '      right: 0;\n' +
                '      bottom: 0;\n' +
                '      padding: 10px;\n' +
                '      overflow: auto;\n' +
                '      color: #444;\n' +
                '      font-family: Georgia, Palatino, \'Palatino Linotype\', Times, \'Times New Roman\', serif;\n' +
                '      font-size: 16px;\n' +
                '      line-height: 1.5em\n' +
                '    }\n' +
                '    \n' +
                '    a {\n' +
                '      outline: none;\n' +
                '      color: #0645ad;\n' +
                '      text-decoration: none;\n' +
                '    }\n' +
                '    \n' +
                '    a:visited {\n' +
                '      color: #0645ad;\n' +
                '    }\n' +
                '    \n' +
                '    a:hover {\n' +
                '      color: #06e;\n' +
                '    }\n' +
                '    \n' +
                '    a:active {\n' +
                '      color: #faa700;\n' +
                '    }\n' +
                '    \n' +
                '    p {\n' +
                '      margin: 1em 0;\n' +
                '    }\n' +
                '    \n' +
                '    img {\n' +
                '      max-width: 100%;\n' +
                '    }\n' +
                '    \n' +
                '    h1, h2, h3, h4, h5, h6 {\n' +
                '      font-weight: normal;\n' +
                '      color: #111;\n' +
                '      line-height: 1em;\n' +
                '    }\n' +
                '    \n' +
                '    h4, h5, h6 {\n' +
                '      font-weight: bold;\n' +
                '    }\n' +
                '    \n' +
                '    h1 {\n' +
                '      font-size: 2.5em;\n' +
                '    }\n' +
                '    \n' +
                '    h2 {\n' +
                '      font-size: 2em;\n' +
                '      border-bottom: 1px solid silver;\n' +
                '      padding-bottom: 5px;\n' +
                '    }\n' +
                '    \n' +
                '    h3 {\n' +
                '      font-size: 1.5em;\n' +
                '    }\n' +
                '    \n' +
                '    h4 {\n' +
                '      font-size: 1.2em;\n' +
                '    }\n' +
                '    \n' +
                '    h5 {\n' +
                '      font-size: 1em;\n' +
                '    }\n' +
                '    \n' +
                '    h6 {\n' +
                '      font-size: 0.9em;\n' +
                '    }\n' +
                '    \n' +
                '    blockquote {\n' +
                '      color: #666666;\n' +
                '      margin: 0;\n' +
                '      padding-left: 3em;\n' +
                '      border-left: 0.5em #EEE solid;\n' +
                '    }\n' +
                '    \n' +
                '    hr {\n' +
                '      display: block;\n' +
                '      height: 2px;\n' +
                '      border: 0;\n' +
                '      border-top: 1px solid #aaa;\n' +
                '      border-bottom: 1px solid #eee;\n' +
                '      margin: 1em 0;\n' +
                '      padding: 0;\n' +
                '    }\n' +
                '    \n' +
                '    pre, code {\n' +
                '      color: #000;\n' +
                '      font-family: Consolas, "Liberation Mono", Menlo, Courier, monospace;\n' +
                '      font-size: 0.94em; /* 0.94 = 0.88 + (1.00 - 0.88) / 2 */\n' +
                '      border-radius: 3px;\n' +
                '      background-color: #F8F8F8;\n' +
                '      border: 1px solid #CCC;\n' +
                '    }\n' +
                '    \n' +
                '    pre {\n' +
                '      white-space: pre;\n' +
                '      white-space: pre-wrap;\n' +
                '      word-wrap: break-word;\n' +
                '      padding: 5px;\n' +
                '    }\n' +
                '    \n' +
                '    pre code {\n' +
                '      border: 0px !important;\n' +
                '      background: transparent !important;\n' +
                '      line-height: 1.3em;\n' +
                '    }\n' +
                '    \n' +
                '    code {\n' +
                '      padding: 0 3px 0 3px;\n' +
                '    }\n' +
                '    \n' +
                '    sub, sup {\n' +
                '      font-size: 75%;\n' +
                '      line-height: 0;\n' +
                '      position: relative;\n' +
                '      vertical-align: baseline;\n' +
                '    }\n' +
                '    \n' +
                '    sup {\n' +
                '      top: -0.5em;\n' +
                '    }\n' +
                '    \n' +
                '    sub {\n' +
                '      bottom: -0.25em;\n' +
                '    }\n' +
                '    \n' +
                '    ul, ol {\n' +
                '      margin: 1em 0;\n' +
                '      padding: 0 0 0 2em;\n' +
                '    }\n' +
                '    \n' +
                '    li p:last-child {\n' +
                '      margin: 0\n' +
                '    }\n' +
                '    \n' +
                '    dd {\n' +
                '      margin: 0 0 0 2em;\n' +
                '    }\n' +
                '    \n' +
                '    img {\n' +
                '      border: 0;\n' +
                '      -ms-interpolation-mode: bicubic;\n' +
                '      vertical-align: middle;\n' +
                '    }\n' +
                '    \n' +
                '    table {\n' +
                '      border-collapse: collapse;\n' +
                '      border-spacing: 0;\n' +
                '    }\n' +
                '    \n' +
                '    td, th {\n' +
                '      vertical-align: top;\n' +
                '      padding: 4px 10px;\n' +
                '      border: 1px solid #bbb;\n' +
                '      max-width: 300px;\n' +
                '      overflow: hidden;\n' +
                '      text-overflow: ellipsis;\n' +
                '    }\n' +
                '    \n' +
                '    tr:nth-child(even) td, tr:nth-child(even) th {\n' +
                '      background: #efefef;\n' +
                '    }\n' +
                '    \n' +
                '    tr:nth-child(odd) td:hover, tr:nth-child(odd) th:hover {\n' +
                '      background: #efefef;\n' +
                '    }\n' +
                '    \n' +
                '    tr:nth-child(even) td:hover, tr:nth-child(even) th:hover {\n' +
                '      background: white;\n' +
                '    }\n' +
                '    \n' +
                '    table th {\n' +
                '      white-space: nowrap;\n' +
                '    }\n' +
                '    \n' +
                '    .topAnchor {\n' +
                '      display: block;\n' +
                '      position: fixed;\n' +
                '      z-index: 1001;\n' +
                '      bottom: 10px;\n' +
                '      right: 0;\n' +
                '      margin: 0;\n' +
                '      padding: 0;\n' +
                '      background-color: #c9c9c9;\n' +
                '    }\n' +
                '    \n' +
                '    .topAnchor a {\n' +
                '      display: block;\n' +
                '      padding: 12px;\n' +
                '      background: rgba(255, 255, 255, .5);\n' +
                '    }\n' +
                '    \n' +
                '    .topAnchor a span {\n' +
                '      display: block;\n' +
                '      width: 24px;\n' +
                '      height: 24px;\n' +
                '      background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAQAAABKfvVzAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAAmJLR0QA/4ePzL8AAAAHdElNRQfeAhkNNgFF8q46AAAAd0lEQVQ4y+2RoQ2AMBAADwGisjBPh2CLahzrgMEwAmuVYIogBFIa+iHB9eT/3ZuHzA8U0WlFC8xssiMlPQ5HTynVVzxelpz6xIRnTSWnPqDRjKnk0msAmvck1BNJQffQ70kXPkCxRPQrWVDhwmAj+pFYjOQjmc/sNUsv1+vGNvUAAAAldEVYdGRhdGU6Y3JlYXRlADIwMTYtMDktMTdUMTU6MTk6NDErMDg6MDD2piBqAAAAJXRFWHRkYXRlOm1vZGlmeQAyMDE0LTAyLTI1VDEzOjU0OjAxKzA4OjAwtu6diAAAAE10RVh0c29mdHdhcmUASW1hZ2VNYWdpY2sgNy4wLjEtNiBRMTYgeDg2XzY0IDIwMTYtMDktMTcgaHR0cDovL3d3dy5pbWFnZW1hZ2ljay5vcmfd2aVOAAAAGHRFWHRUaHVtYjo6RG9jdW1lbnQ6OlBhZ2VzADGn/7svAAAAGHRFWHRUaHVtYjo6SW1hZ2U6OkhlaWdodAAxMjhDfEGAAAAAF3RFWHRUaHVtYjo6SW1hZ2U6OldpZHRoADEyONCNEd0AAAAZdEVYdFRodW1iOjpNaW1ldHlwZQBpbWFnZS9wbmc/slZOAAAAF3RFWHRUaHVtYjo6TVRpbWUAMTM5MzMwNzY0MWqa+K0AAAASdEVYdFRodW1iOjpTaXplADEuNjlLQvWCP7QAAABfdEVYdFRodW1iOjpVUkkAZmlsZTovLy9ob21lL3d3d3Jvb3Qvc2l0ZS93d3cuZWFzeWljb24ubmV0L2Nkbi1pbWcuZWFzeWljb24uY24vc3JjLzExMzc3LzExMzc3NDgucG5nniX3RQAAAABJRU5ErkJggg==");\n' +
                '    }\n' +
                '    \n' +
                '    @media (min-width: 800px) {\n' +
                '      body {\n' +
                '        padding-left: 0;\n' +
                '        padding-top: 0;\n' +
                '      }\n' +
                '    \n' +
                '      .catalog {\n' +
                '        position: fixed;\n' +
                '        width: 24%;\n' +
                '        height: 100%;\n' +
                '    \n' +
                '        overflow: auto;\n' +
                '        border-right: 1px solid #e5e5e5;\n' +
                '        border-bottom: 0;\n' +
                '        background-color: #ededed;\n' +
                '      }\n' +
                '    \n' +
                '      .content {\n' +
                '        position: absolute;\n' +
                '        left: 24%;\n' +
                '        width: 75%;\n' +
                '        height: 100%;\n' +
                '        margin-left: 1%;\n' +
                '      }\n' +
                '    }' +
                '  </style>\n' +
                '</head>\n' +
                '<body>\n' +
                '<div class="catalog">\n' +
                new PegDownProcessor(Extensions.ALL_WITH_OPTIONALS ^ Extensions.SMARTYPANTS).markdownToHtml(catalog) +
                '</div>\n' +
                '<div class="content">\n'

        def footer = '</div>\n' +
                '<div class="topAnchor">\n' +
                '  <a href="#">\n' +
                '    <span></span>\n' +
                '  </a>\n' +
                '</div>\n' +
                '</body>\n' +
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
                        }.toHtml(astRoot)
                    } catch (ParsingTimeoutException ignored) {
                        return null
                    }
                }
            }.markdownToHtml(inFile.text.replace('.md', '.html')) + footer
        }
    }

/**
 * 过滤注释
 * @param file
 * @return
 */
    static jsonFilter(File file) {
        file.filterLine {
            !it.contains('//')
        }.toString()
    }
}