package cn.bestwu.apidoc.starter;

import cn.bestwu.dbscript.DbScriptExtension;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Peter Wu
 * @since 1.3.8
 */
@ConfigurationProperties("api.dbscript")
public class DbScriptProperties extends DbScriptExtension {

}
