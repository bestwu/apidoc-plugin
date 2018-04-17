package cn.bestwu.apidoc.starter

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 生成文档相关数据
 *
 * @author Peter Wu
 */
class ApiDocHandlerInterceptor : HandlerInterceptorAdapter() {

    companion object {
        val HANDLER_METHOD = ApiDocHandlerInterceptor::class.java.name + ".HandlerMethod"
    }

    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
        if (ApiDoc.enable && handler is HandlerMethod && handler.bean !is ErrorController) {
            request.setAttribute(HANDLER_METHOD, handler)
        }
    }
}
