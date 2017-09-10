package cn.bestwu.apidoc

import java.util.*

/**
 *
 * @author Peter Wu
 * @since
 */

data class Api(
        var method: String = "",
        var name: String = "",
        var desc: String = "",
        var headers: Map<String, Array<String>> = mapOf(),
        var params: Map<String, Any?> = mapOf(),
        var results: Map<String, Any?> = mapOf(),
        var resource: String = "",
        var uriVariables: String = "",
        var url: String = "",
        var version: Array<String> = arrayOf(),
        var extra: Map<String, Api>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Api) return false

        if (method != other.method) return false
        if (name != other.name) return false
        if (desc != other.desc) return false
        if (params != other.params) return false
        if (results != other.results) return false
        if (resource != other.resource) return false
        if (uriVariables != other.uriVariables) return false
        if (url != other.url) return false
        if (!Arrays.equals(version, other.version)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = method.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + desc.hashCode()
        result = 31 * result + params.hashCode()
        result = 31 * result + results.hashCode()
        result = 31 * result + resource.hashCode()
        result = 31 * result + uriVariables.hashCode()
        result = 31 * result + url.hashCode()
        result = 31 * result + Arrays.hashCode(version)
        return result
    }
}

data class Field(
        var name: String = "",
        var desc: String = "",
        var nullable: Boolean = true,
        var nullableDesc: String = "否",
        var type: String = "String",
        var tempValue: Any?,
        var value:  Any?
)

data class Child(
        var text: String = "",
        var leaf: Boolean = true
)

data class Tree(
        var children: Array<Child> = arrayOf(),
        var text: String = "",
        var expanded: Boolean = true
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Tree) return false

        if (!Arrays.equals(children, other.children)) return false
        if (text != other.text) return false
        if (expanded != other.expanded) return false

        return true
    }

    override fun hashCode(): Int {
        var result = Arrays.hashCode(children)
        result = 31 * result + text.hashCode()
        result = 31 * result + expanded.hashCode()
        return result
    }
}