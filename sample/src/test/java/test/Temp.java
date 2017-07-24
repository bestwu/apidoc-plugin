package test;

import cn.bestwu.gradle.apidoc.support.HtmlGenerator;
import java.io.File;
import org.junit.Test;

/**
 * @author Peter Wu
 */
public class Temp {

  @Test
 public void test() throws Exception {
    HtmlGenerator.generate(
        new File("/data/repositories/bestwu/apidoc-plugin/sample/src/main/resources/test"),
        new File("/data/repositories/bestwu/apidoc-plugin/sample/src/main/resources/test/html"),
        "UTF-8");
  }
}
