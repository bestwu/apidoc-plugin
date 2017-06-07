package cn.bestwu.gradle.apidoc

import org.gradle.api.tasks.Input

/**
 * @author Peter Wu
 */
class ApidocExtension {
    @Input
    String encoding = 'UTF-8'
    @Input
    String apiHost = ''
    @Input
    String defaultHost = ''
    @Input
    String[] paths = ['_t']
    @Input
    String sourcePath='src/main/resources'
}
