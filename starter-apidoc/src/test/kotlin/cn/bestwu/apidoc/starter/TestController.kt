package cn.bestwu.apidoc.starter

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Peter Wu
 */
@ImportAutoConfiguration(ApiDocConfiguration::class)
@SpringBootApplication
@RestController
class TestController {

    @GetMapping(value = ["/waybills/{path}"], name = "测试")
    fun dests(): Any {
        return ObjectMapper().readValue("{\"size\":5,\"total\":5,\"pages\":1,\"list\":[{\"id\":72,\"goodsNo\":\"557646\",\"consigneeName\":\"赵国柱1\",\"consigneeTel\":\"18819295194\",\"consigneeAddress\":\"东坡区苏祠路13号逸静苑大门向南方向5米\",\"status\":1,\"finished\":false},{\"id\":12,\"goodsNo\":\"718000872266\",\"consigneeName\":\"江涛\",\"consigneeTel\":\"13684030501\",\"consigneeAddress\":\"碧辉园\",\"status\":1,\"finished\":false},{\"id\":71,\"goodsNo\":\"2222\",\"consigneeName\":\"赵国柱1\",\"consigneeTel\":\"18819295194\",\"consigneeAddress\":\"东坡区文安路东二段与永和街交叉口东50米\",\"status\":1,\"finished\":false},{\"id\":13,\"goodsNo\":\"1234\",\"consigneeName\":\"江涛\",\"consigneeTel\":\"13684030501\",\"consigneeAddress\":\"眉山东站\",\"status\":1,\"finished\":true},{\"id\":161,\"goodsNo\":\"718000872252\",\"consigneeName\":\"SDF\",\"consigneeTel\":\"18224060100\",\"consigneeAddress\":\"湿地\",\"status\":1,\"finished\":true}],\"page\":1}", Map::class.java)
    }
}