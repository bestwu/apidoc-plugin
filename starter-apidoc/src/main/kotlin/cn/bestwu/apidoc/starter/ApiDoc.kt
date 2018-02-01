package cn.bestwu.apidoc.starter

/**
 * 接口文档数据模型
 */
object ApiDoc {

    /**
     * 相关数据表名
     */
    var tableNames: Array<out String> = arrayOf()

    /**
     * 必填参数
     */
    var requires: Array<out String> = arrayOf()
    /**
     * 是否需要签名
     */
    var needSign: Boolean = true
    /**
     * 是否启用文档数据生成
     */
    var enable: Boolean = false
    /**
     * 开发者
     */
    var author: String = ""
    /**
     * 接口名称
     */
    var name: String = ""

    /**
     * 相关数据表名
     */
    fun tableNames(vararg tableName: String) {
        tableNames = tableName
        enable = true
    }

    /**
     * 开发者
     */
    fun author(author: String) {
        ApiDoc.author = author
    }

    /**
     * 接口名称
     */
    fun name(name: String) {
        ApiDoc.name = name
    }

    /**
     * 必填参数
     */
    fun requires(vararg require: String) {
        requires = require
    }

    /**
     * 是否启用文档数据生成
     */
    fun enable() {
        enable = true
    }
}
