package cn.bestwu.apidoc

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import org.junit.Test
import java.io.File

/**
 * @author Peter Wu
 * @since
 */
class MDGeneratorTest {

    @Suppress("UNCHECKED_CAST")
    @Test
    fun generate() {
        val parser = Parser()
        val tree = (parser.parse(MDGeneratorTest::class.java.getResourceAsStream("/_t/tree.json")) as JsonArray<JsonObject>)[0]
        val apis = parser.parse(MDGeneratorTest::class.java.getResourceAsStream("/_t/api.json")) as JsonArray<JsonObject>
        val fields = parser.parse(MDGeneratorTest::class.java.getResourceAsStream("/_t/field.json")) as JsonArray<JsonObject>
        val parentFile = File(MDGeneratorTest::class.java.getResource("/_t/tree.json").file).parentFile
        MDGenerator.call(tree, apis, fields, File(parentFile,"md"), "http://127.0.0.1")
    }

}