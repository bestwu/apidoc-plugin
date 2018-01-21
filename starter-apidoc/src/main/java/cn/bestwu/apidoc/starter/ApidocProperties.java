package cn.bestwu.apidoc.starter;

import cn.bestwu.apidoc.ApidocExtension;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Peter Wu
 * @since 1.3.8
 */
@ConfigurationProperties("api.apidoc")
public class ApidocProperties extends ApidocExtension {

  /**
   * 需要生成文档数据的 Controller类名前缀.
   */
  private String[] handlerTypePrefix = {};
  /**
   * 接口版本号.
   */
  private String[] version = {"1.0"};

  public String[] getHandlerTypePrefix() {
    return handlerTypePrefix;
  }

  public void setHandlerTypePrefix(String[] handlerTypePrefix) {
    this.handlerTypePrefix = handlerTypePrefix;
  }

  public String[] getVersion() {
    return version;
  }

  public void setVersion(String[] version) {
    this.version = version;
  }
}
