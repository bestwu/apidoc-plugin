
import cn.bestwu.apidoc.ApidocExtension
import cn.bestwu.apidoc.HtmlGenerator
import cn.bestwu.apidoc.MDGenerator
import org.junit.Before
import org.junit.Test
import java.io.File

/**
 *
 * @author Peter Wu
 * @since
 */
class Test {
    lateinit var apidocExtension: ApidocExtension
    @Before
    fun setUp() {
        val parentFile = File(Test::class.java.getResource("/_t").file).parentFile
        apidocExtension = ApidocExtension("http://127.0.0.1", paths = arrayOf("_t"), sourcePath = parentFile.absolutePath)
    }

    @Test
    fun generateMd() {
        MDGenerator.call(apidocExtension)
    }

    @Test
    fun generateHtml() {
        HtmlGenerator.call(apidocExtension)
    }
}