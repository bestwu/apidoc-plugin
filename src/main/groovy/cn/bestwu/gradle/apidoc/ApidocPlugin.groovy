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
                    project.apidoc.paths.each { path ->
                        def sourcePath = project.apidoc.sourcePath + '/' + path
                        def inputDir = project.file(sourcePath)
                        def outputDir = project.file(sourcePath + '/md')
                        if (!outputDir.exists())
                            outputDir.mkdirs()
                        inputs.files inputDir.listFiles(new FileFilter() {
                            @Override
                            boolean accept(File pathname) {
                                return pathname != outputDir && pathname != project.file(sourcePath + '/html')
                            }
                        })
                        outputs.dir outputDir
                    }
                    cover project.apidoc.cover
                    apiHost project.apidoc.apiHost == '' ? project.apidoc.defaultHost : project.apidoc.apiHost
                }
                project.task('htmldoc', dependsOn: project.mddoc, type: HtmlTask, description: '') {
                    project.apidoc.paths.each { path ->
                        def sourcePath = project.apidoc.sourcePath + '/' + path
                        inputs.dir sourcePath + '/md'
                        inputs.files project.file(sourcePath).listFiles(new FileFilter() {
                            @Override
                            boolean accept(File file) {
                                return file.name.endsWith('.md')
                            }
                        })
                        outputs.dir sourcePath + '/html'
                    }
                }
                project.task('alphaMddoc', type: MDTask, description: '') {
                    project.apidoc.paths.each { path ->
                        def sourcePath = project.apidoc.sourcePath + '/' + path
                        def inputDir = project.file(sourcePath)
                        def outputDir = project.file(sourcePath + '/md')
                        inputs.files inputDir.listFiles(new FileFilter() {
                            @Override
                            boolean accept(File pathname) {
                                return pathname != outputDir && pathname != project.file(sourcePath + '/html')
                            }
                        })

                        outputs.dir outputDir
                    }
                    cover project.apidoc.cover
                    apiHost project.apidoc.defaultHost
                }
                project.task('alphaHtmldoc', dependsOn: project.alphaMddoc, type: HtmlTask, description: '') {
                    project.apidoc.paths.each { path ->
                        def sourcePath = project.apidoc.sourcePath + '/' + path
                        inputs.dir sourcePath + '/md'
                        inputs.files project.file(sourcePath).listFiles(new FileFilter() {
                            @Override
                            boolean accept(File file) {
                                return file.name.endsWith('.md')
                            }
                        })
                        outputs.dir sourcePath + '/html'
                    }
                    doFirst {
                        alphaMddoc.execute()
                    }
                }
            }
        }
    }
}