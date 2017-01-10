package cn.bestwu.gradle.apidoc

import cn.bestwu.gradle.apidoc.tasks.ApidocTask
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
        project.task('apidoc', type: ApidocTask, group: 'app', description: '') {}
    }
}