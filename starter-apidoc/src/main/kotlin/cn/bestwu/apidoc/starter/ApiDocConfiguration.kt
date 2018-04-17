package cn.bestwu.apidoc.starter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.annotation.PostConstruct

/**
 * @author Peter Wu
 * @since 1.3.8
 */
@EnableConfigurationProperties(GeneratorProperties::class, ApidocProperties::class)
@Configuration
class ApiDocConfiguration : WebMvcConfigurer {
    @Autowired
    private lateinit var generatorProperties: GeneratorProperties
    @Autowired
    private lateinit var apidocProperties: ApidocProperties
    @Value("\${spring.application.name:}")
    private lateinit var projectName: String

    @PostConstruct
    fun init() {
        if (apidocProperties.projectName.isBlank()) {
            apidocProperties.projectName = projectName
        }
    }

    @Bean
    fun apidocFilter(): ApiDocFilter {
        return ApiDocFilter(generatorProperties, apidocProperties)
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(ApiDocHandlerInterceptor())
    }
}
