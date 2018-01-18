package cn.bestwu.apidoc


/**
 * @author Peter Wu
 */
open class ApidocExtension(
        var projectName: String = "",
        var author: String = "",
        var apiHost: String = "",
        var defaultHost: String = "",
        var paths: Array<String> = arrayOf("_t"),
        var cover: Boolean = true,
        /**
         * 严格模式字段解析
         */
        var strict: Boolean = true,
        var sourcePath: String = "src/main/resources"
)
