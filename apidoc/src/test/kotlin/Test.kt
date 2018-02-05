import cn.bestwu.apidoc.ApidocExtension
import cn.bestwu.apidoc.Field
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
        apidocExtension = ApidocExtension("文档", apiHost = "http://127.0.0.1", paths = arrayOf("_t"), sourcePath = parentFile.absolutePath)
    }

    @Test
    fun generateMd() {
        MDGenerator.call(apidocExtension)
    }

    @Test
    fun copy() {
        val field = Field()
        field.id="234"

        val copy = field.copy()
        System.err.println(field.id)
        System.err.println(copy.id)

        copy.id="12"
        System.err.println(field.id)
        System.err.println(copy.id)
    }

    @Test
    fun generateHtml() {
        MDGenerator.call(apidocExtension)
        HtmlGenerator.call(apidocExtension)
    }
}