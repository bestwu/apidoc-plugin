package cn.bestwu.apidoc.starter

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * 控制层测试
 *
 * @author Peter Wu
 */
@RunWith(SpringRunner::class)
@WebMvcTest(TestController::class)
class ControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun test() {
        ApiDoc.tableNames("waybill")

        val mvcResult = mockMvc
                .perform(get("/waybills/1"))
                .andExpect(status().isOk).andReturn()
        System.err.println(mvcResult.response.contentAsString)
    }
}
