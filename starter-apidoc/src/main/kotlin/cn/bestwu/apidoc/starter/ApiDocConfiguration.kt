package cn.bestwu.apidoc.starter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.StringUtils
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * @author Peter Wu
 * @since 1.3.8
 */
@Conditional(ApiDocConfiguration.ApiDocCondition::class)
@EnableConfigurationProperties(GeneratorProperties::class, ApidocProperties::class)
@Configuration
class ApiDocConfiguration : WebMvcConfigurer {
    @Autowired
    private lateinit var generatorProperties: GeneratorProperties
    @Autowired
    private lateinit var apidocProperties: ApidocProperties

    @Bean
    fun apidocFilter(): ApiDocFilter {
        return ApiDocFilter(generatorProperties, apidocProperties)
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(ApiDocHandlerInterceptor(apidocProperties))
    }

    internal class ApiDocCondition : Condition {

        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            return StringUtils.hasText(context.environment.getProperty("api.apidoc.handler-type-prefix")) || StringUtils.hasText(context.environment.getProperty("api.apidoc.handlerTypePrefix"))
        }
    }
}
