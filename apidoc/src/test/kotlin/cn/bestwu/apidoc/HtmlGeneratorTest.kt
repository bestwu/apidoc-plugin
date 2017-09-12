package cn.bestwu.apidoc

import org.junit.Test
import java.io.File

/**
 * @author Peter Wu
 * @since
 */
class HtmlGeneratorTest {

    @Test
    fun generate() {
        val parentFile = File(MDGeneratorTest::class.java.getResource("/_t/tree.json").file).parentFile
        HtmlGenerator.call(File(parentFile,"md"),File(parentFile,"html"))
    }

}