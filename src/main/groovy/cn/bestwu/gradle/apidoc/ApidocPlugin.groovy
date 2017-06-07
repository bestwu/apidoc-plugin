package cn.bestwu.gradle.apidoc

import cn.bestwu.gradle.apidoc.tasks.HtmlTask
import cn.bestwu.gradle.apidoc.tasks.MDTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *
 * 注册task
 *
 * @author Peter Wu
 */
class ApidocPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.configure(project) {
            project.extensions.create('apidoc', ApidocExtension)
            afterEvaluate {
                project.task('mddoc', type: MDTask, description: '') {
                    def inputDir = project.file(project.apidoc.input)
                    def outputDir = project.file(project.apidoc.output + '/md')
                    if (!outputDir.exists())
                        outputDir.mkdirs()
                    inputs.files inputDir.listFiles(new FileFilter() {
                        @Override
                        boolean accept(File pathname) {
                            return pathname != outputDir && pathname != project.file(project.apidoc.output + '/html')
                        }
                    })

                    input inputDir
                    output outputDir
                    apiHost project.apidoc.apiHost == '' ? project.apidoc.defaultHost : project.apidoc.apiHost
                    encoding project.apidoc.encoding
                }
                project.task('htmldoc', dependsOn: project.mddoc, type: HtmlTask, description: '') {
                    input project.file(project.apidoc.output + '/md')
                    output project.file(project.apidoc.output + '/html')
                    encoding project.apidoc.encoding
                }
                project.task('alphaMddoc', type: MDTask, description: '') {
                    def inputDir = project.file(project.apidoc.input)
                    def outputDir = project.file(project.apidoc.output + '/md')
                    inputs.files inputDir.listFiles(new FileFilter() {
                        @Override
                        boolean accept(File pathname) {
                            return pathname != outputDir && pathname != project.file(project.apidoc.output + '/html')
                        }
                    })

                    input inputDir
                    output outputDir
                    apiHost project.apidoc.defaultHost
                    encoding project.apidoc.encoding
                }
                project.task('alphaHtmldoc', type: HtmlTask, description: '') {
                    input project.file(project.apidoc.output + '/md')
                    output project.file(project.apidoc.output + '/html')
                    encoding project.apidoc.encoding
                    doFirst {
                        alphaMddoc.execute()
                    }
                }
            }
        }
    }
}