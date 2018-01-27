package cn.bestwu.apidoc.starter;

import cn.bestwu.generator.GeneratorExtension;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Peter Wu
 * @since 1.3.8
 */
@ConfigurationProperties("api.generators")
public class GeneratorProperties extends GeneratorExtension {

}
