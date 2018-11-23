package core.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.Objects;

import core.utils.constants.GlobalConstants;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j;

import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * Created by Vitalii_Strieltsov on 11/20/2018
 */
@UtilityClass
@Log4j
public class FileUtils {

  /**
   * Get path of recourse file from project build directory
   *
   * @param recourseFileName full file name from resources folder
   * @return path to file in build directory
   */
  @SneakyThrows
  public static String getRecoursePath(String recourseFileName) {
    URI uri = Objects.requireNonNull(
        Thread.currentThread()
            .getContextClassLoader()
            .getResource(recourseFileName))
        .toURI();
    return Paths.get(uri).toString();
  }

  public static String fileReader(String filePath) {
    StringBuilder sb = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(String.format(GlobalConstants.FILE_PATH_TEMPLATE, filePath)))) {
      String line;

      while ((line = br.readLine()) != null) {
        sb.append(line).append("\r\n");
      }
    } catch (IOException e) {
      log.error("Exception: " + e.toString());
    }
    return sb.toString();
  }
}
