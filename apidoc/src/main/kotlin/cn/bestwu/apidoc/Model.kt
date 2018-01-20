package cn.bestwu.apidoc


/**
 *
 * @author Peter Wu
 */
data class Api(val map: MutableMap<String, Any?>) : MutableMap<String, Any?> by map {
    var method: String  by map
    var name: String  by map
    var author: String?  by map
    var desc: String?  by map
    var headers: Map<String, Any?>?  by map
    var params: Map<String, Any?>?  by map
    var results: Any?  by map
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


