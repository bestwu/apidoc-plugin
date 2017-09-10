package cn.bestwu.apidoc


/**
 * @author Peter Wu
 */
open class ApidocExtension(
        var encoding: String = "UTF-8",
        var apiHost: String = "",
        var defaultHost: String = "",
        var paths: Array<String> = arrayOf("_t"),
        var cover: Boolean = true,
        var sourcePath: String = "src/main/resources"
)
