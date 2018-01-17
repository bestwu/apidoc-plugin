package cn.bestwu.apidoc


/**
 *
 * @author Peter Wu
 * @since
 */
private fun <A : Appendable> A.renderString(s: String): A {
    append("\"")

    (0 until s.length)
            .map { s[it] }
            .forEach {
                when (it) {
                    '"' -> append("\\").append(it)
                    '\\' -> append(it).append(it)
                    '\n' -> append("\\n")
                    '\r' -> append("\\r")
                    '\t' -> append("\\t")
                    '\b' -> append("\\b")
                    '\u000c' -> append("\\f")
                    else -> {
                        if (isPrintableUnicode(it)) {
                            append("\\u")
                            append(Integer.toHexString(it.toInt()).padStart(4, '0'))
                        } else {
                            append(it)
                        }
                    }
                }
            }

    append("\"")
    return this
}

private fun isPrintableUnicode(c: Char): Boolean = ((c in '\u0000'..'\u001F')
        || (c in '\u007F'..'\u009F') || (c in '\u2000'..'\u20FF'))

fun renderValue(value: Any?, result: Appendable, prettyPrint: Boolean, level: Int) {
    when (value) {
        is String -> result.renderString(value)
        is Map<*, *> -> {
            result.append("{")

            var comma = false
            for ((k, v) in value) {
                if (comma) {
                    result.append(",")
                } else {
                    comma = true
                }

                if (prettyPrint) {
                    result.appendln()
                    result.indent(level + 1)
                }

                result.append("\"").append(k.toString()).append("\":")
                if (prettyPrint) {
                    result.append(" ")
                }

                renderValue(v, result, prettyPrint, level + 1)
            }

            if (prettyPrint && value.isNotEmpty()) {
                result.appendln()
                result.indent(level)
            }

            result.append("}")
        }
        is List<*> -> {
            result.append("[")

            var comma = false
            value.forEach {
                if (comma) {
                    result.append(",")
                    if (prettyPrint) {
                        result.append(" ")
                    }
                } else {
                    comma = true
                }

                renderValue(it, result, prettyPrint, level)
            }
            result.append("]")
        }
        is Pair<*, *> -> renderValue(value.second, result.renderString(value.first.toString()).append(": "), prettyPrint, level)
        else -> result.append(value.toString())
    }
}

internal fun Any.toJsonString(prettyPrint: Boolean = false): String {
    return StringBuilder().also { renderValue(this, it, prettyPrint, 0) }.toString()
}

data class Api(val map: MutableMap<String, Any?>) : MutableMap<String, Any?> by map {
    var method: String  by map
    var name: String  by map
    var desc: String?  by map
    var headers: Map<String, Any?>?  by map
    var params: Map<String, Any?>?  by map
    var results: Map<String, Any?>?  by map
    var resource: String  by map
    var uriVariables: Map<String, Any?>?  by map
    var url: String  by map
    var version: List<String>?  by map
}

data class Field(val map: MutableMap<String, Any?>) : MutableMap<String, Any?> by map {
    var id: String? = map["id"] as? String
    val name: String by map
    var desc: String? by map
    var nullable: Boolean? by map
    /**
     * 是否必填
     */
    val nullableDesc: String
        get() = if (nullable == null || nullable!!) "否" else "是"
    var type: String? by map
    var value: Any? by map
    var tempValue: Any? = null
}

data class Child(val map: MutableMap<String, Any?>) : MutableMap<String, Any?> by map {
    var text: String  by map
    var leaf: Boolean  by map
}

data class Tree(val map: MutableMap<String, Any?>) : MutableMap<String, Any?> by map {
    @Suppress("UNCHECKED_CAST")
    var children: List<Child>? = (map["children"] as? List<MutableMap<String, Any?>>)?.map { Child(it) }
    var text: String  by map
    var expanded: Boolean  by map
}


