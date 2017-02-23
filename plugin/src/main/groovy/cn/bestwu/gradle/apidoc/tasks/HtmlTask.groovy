package cn.bestwu.gradle.apidoc.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.pegdown.Extensions
import org.pegdown.PegDownProcessor

/**
 * 生成接口文档
 *
 * @author Peter Wu
 */
class HtmlTask extends DefaultTask {

    @Input
    String encoding = 'UTF-8'
    @InputDirectory
    File input
    @OutputDirectory
    File output

    @TaskAction
    run() {
        if (!output.exists()) {
            output.mkdirs()
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
                '  <style type="text/css">\n' +
                '    body {\n' +
                '      margin: 0;\n' +
                '      left: 0;\n' +
                '      top: 0;\n' +
                '      right: 0;\n' +
                '      bottom: 0;\n' +
                '      overflow: auto;\n' +
                '      padding: 10px;\n' +
                '      color: #444;\n' +
                '      font-family: Georgia, Palatino, \'Palatino Linotype\', Times, \'Times New Roman\', serif;\n' +
                '      font-size: 16px;\n' +
                '      line-height: 1.5em\n' +
                '    }\n' +
                '\n' +
                '    a {\n' +
                '      color: #0645ad;\n' +
                '      text-decoration: none;\n' +
                '    }\n' +
                '\n' +
                '    a:visited {\n' +
                '      color: #0b0080;\n' +
                '    }\n' +
                '\n' +
                '    a:hover {\n' +
                '      color: #06e;\n' +
                '    }\n' +
                '\n' +
                '    a:active {\n' +
                '      color: #faa700;\n' +
                '    }\n' +
                '\n' +
                '    a:focus {\n' +
                '      outline: thin dotted;\n' +
                '    }\n' +
                '\n' +
                '    a:hover, a:active {\n' +
                '      outline: 0;\n' +
                '    }\n' +
                '\n' +
                '    p {\n' +
                '      margin: 1em 0;\n' +
                '    }\n' +
                '\n' +
                '    img {\n' +
                '      max-width: 100%;\n' +
                '    }\n' +
                '\n' +
                '    h1, h2, h3, h4, h5, h6 {\n' +
                '      font-weight: normal;\n' +
                '      color: #111;\n' +
                '      line-height: 1em;\n' +
                '    }\n' +
                '\n' +
                '    h4, h5, h6 {\n' +
                '      font-weight: bold;\n' +
                '    }\n' +
                '\n' +
                '    h1 {\n' +
                '      font-size: 2.5em;\n' +
                '    }\n' +
                '\n' +
                '    h2 {\n' +
                '      font-size: 2em;\n' +
                '      border-bottom: 1px solid silver;\n' +
                '      padding-bottom: 5px;\n' +
                '    }\n' +
                '\n' +
                '    h3 {\n' +
                '      font-size: 1.5em;\n' +
                '    }\n' +
                '\n' +
                '    h4 {\n' +
                '      font-size: 1.2em;\n' +
                '    }\n' +
                '\n' +
                '    h5 {\n' +
                '      font-size: 1em;\n' +
                '    }\n' +
                '\n' +
                '    h6 {\n' +
                '      font-size: 0.9em;\n' +
                '    }\n' +
                '\n' +
                '    blockquote {\n' +
                '      color: #666666;\n' +
                '      margin: 0;\n' +
                '      padding-left: 3em;\n' +
                '      border-left: 0.5em #EEE solid;\n' +
                '    }\n' +
                '\n' +
                '    hr {\n' +
                '      display: block;\n' +
                '      height: 2px;\n' +
                '      border: 0;\n' +
                '      border-top: 1px solid #aaa;\n' +
                '      border-bottom: 1px solid #eee;\n' +
                '      margin: 1em 0;\n' +
                '      padding: 0;\n' +
                '    }\n' +
                '\n' +
                '    pre, code {\n' +
                '      color: #000;\n' +
                '      font-family: Consolas, "Liberation Mono", Menlo, Courier, monospace;\n' +
                '      font-size: 0.94em; /* 0.94 = 0.88 + (1.00 - 0.88) / 2 */\n' +
                '      border-radius: 3px;\n' +
                '      background-color: #F8F8F8;\n' +
                '      border: 1px solid #CCC;\n' +
                '    }\n' +
                '\n' +
                '    pre {\n' +
                '      white-space: pre;\n' +
                '      white-space: pre-wrap;\n' +
                '      word-wrap: break-word;\n' +
                '      padding: 5px;\n' +
                '    }\n' +
                '\n' +
                '    pre code {\n' +
                '      border: 0px !important;\n' +
                '      background: transparent !important;\n' +
                '      line-height: 1.3em;\n' +
                '    }\n' +
                '\n' +
                '    code {\n' +
                '      padding: 0 3px 0 3px;\n' +
                '    }\n' +
                '\n' +
                '    sub, sup {\n' +
                '      font-size: 75%;\n' +
                '      line-height: 0;\n' +
                '      position: relative;\n' +
                '      vertical-align: baseline;\n' +
                '    }\n' +
                '\n' +
                '    sup {\n' +
                '      top: -0.5em;\n' +
                '    }\n' +
                '\n' +
                '    sub {\n' +
                '      bottom: -0.25em;\n' +
                '    }\n' +
                '\n' +
                '    ul, ol {\n' +
                '      margin: 1em 0;\n' +
                '      padding: 0 0 0 2em;\n' +
                '    }\n' +
                '\n' +
                '    li p:last-child {\n' +
                '      margin: 0\n' +
                '    }\n' +
                '\n' +
                '    dd {\n' +
                '      margin: 0 0 0 2em;\n' +
                '    }\n' +
                '\n' +
                '    img {\n' +
                '      border: 0;\n' +
                '      -ms-interpolation-mode: bicubic;\n' +
                '      vertical-align: middle;\n' +
                '    }\n' +
                '\n' +
                '    table {\n' +
                '      border-collapse: collapse;\n' +
                '      border-spacing: 0;\n' +
                '    }\n' +
                '\n' +
                '    td, th {\n' +
                '      vertical-align: top;\n' +
                '      padding: 4px 10px;\n' +
                '      border: 1px solid #bbb;\n' +
                '    }\n' +
                '\n' +
                '    tr:nth-child(even) td, tr:nth-child(even) th {\n' +
                '      background: #efefef;\n' +
                '    }\n' +
                '\n' +
                '    tr:nth-child(odd) td:hover, tr:nth-child(odd) th:hover {\n' +
                '      background: #efefef;\n' +
                '    }\n' +
                '\n' +
                '    tr:nth-child(even) td:hover, tr:nth-child(even) th:hover {\n' +
                '      background: white;\n' +
                '    }\n' +
                '\n' +
                '    table th {\n' +
                '      white-space: nowrap;\n' +
                '    }\n' +
                '  </style>\n' +
                '</head>\n' +
                '<body>\n'
        def footer = '\n</body>\n' +
                '</html>'
        outFile.withPrintWriter(encoding) { out ->
            out.println header + new PegDownProcessor(Extensions.ALL_WITH_OPTIONALS).markdownToHtml(inFile.text.replace('.md', '.html')) + footer
        }
    }

}