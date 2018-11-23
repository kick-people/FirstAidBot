package core.utils.config;

import java.util.Properties;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 * Created by Vitalii_Strieltsov on 11/20/2018
 */
@Getter
public class GlobalConfig {

  private static GlobalConfig globalProperties;

  private Properties properties;
  private String baseUrlApi;

  private GlobalConfig(){
    properties = GlobalProperties.getInstance();

    baseUrlApi = properties.getProperty("base.url.api");
  }

  public static GlobalConfig getGlobalConfig() {
    if (globalProperties == null) {
      globalProperties = new GlobalConfig();
    }
    return globalProperties;
  }
}
