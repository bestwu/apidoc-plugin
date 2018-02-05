package cn.bestwu.apidoc

import com.fasterxml.jackson.annotation.JsonAnySetter
import java.util.*


/**
 *
 * @author Peter Wu
 */
data class Api(
        var method: String = "",
        var name: String = "",
        var author: String? = null,
        var desc: String? = null,
        var headers: Map<String, Any?>? = null,
        var params: Map<String, Any?>? = null,
        var results: Any? = null,
        var resource: String = "",
        var uriVariables: Map<String, Any?>? = null,
        var url: String = "",
        var version: List<String>? = null,
        @JsonAnySetter
        private val additionalVersions: Map<String, Api?> = HashMap()
) {
    operator fun get(key: String): Api? {
        return additionalVersions[key]
    }
}

data class Field(
        var id: String? = null,
        var name: String = "",
        var desc: String? = null,
        var nullable: Boolean? = null,
        /**
         * 是否默认展开
         */
        var expanded: Boolean? = null,
        var type: String? = null,
        var value: Any? = null,
        var tempValue: Any? = null) {
    /**
     * 是否必填
     */
    val nullableDesc: String
        get() = if (nullable == null || nullable!!) "否" else "是"

}

data class Child(
        var text: String = "",
        var leaf: Boolean = true
)

data class Tree(
        @Suppress("UNCHECKED_CAST")
        var children: List<Child>? = null,
        var text: String = "",
        var expanded: Boolean = true)


