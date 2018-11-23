package core.utils.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import core.utils.FileUtils;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j;

import static core.utils.constants.GlobalConstants.PROPERTY_NAME;
import static java.text.MessageFormat.format;

/**
 * Created by Vitalii_Strieltsov on 11/20/2018
 */
@UtilityClass
@Log4j
public class GlobalProperties {

  private Properties globalProperties;

  Properties getInstance() {
    if (globalProperties == null) {
      globalProperties = getGlobalProperties(getPropertyFile());
    }
    return globalProperties;
  }

  private static String getPropertyFile() {
    return FileUtils.getRecoursePath(PROPERTY_NAME);
  }

  private static Properties getGlobalProperties(String path) {
    Properties properties = null;
    try (FileInputStream fileInputStream = new FileInputStream(path)) {
      properties = new Properties();
      properties.load(fileInputStream);
    } catch (IOException e) {
      log.error("Error loading global property file", e);
    }
    return properties;
  }
}
