package cn.bestwu.apidoc.starter

import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 生成文档相关数据
 *
 * @author Peter Wu
 */
class ApiDocInterceptor(private var apidocProperties: ApidocProperties) : HandlerInterceptorAdapter() {

    companion object {
        val HANDLER_METHOD = ApiDocInterceptor::class.java.name + ".HandlerMethod"
    }


    @Suppress("UNCHECKED_CAST")
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {
        if (ApiDoc.enable && handler is HandlerMethod && apidocProperties.handlerTypePrefix.any { handler.beanType.name.startsWith(it) }) {
            request.setAttribute(HANDLER_METHOD, handler)
        }
    }


}
