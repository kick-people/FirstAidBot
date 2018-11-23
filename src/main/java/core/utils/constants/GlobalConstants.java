package core.utils.constants;

import java.util.ArrayList;
import java.util.List;

import lombok.experimental.UtilityClass;

/**
 * Created by Vitalii_Strieltsov on 11/20/2018
 */
@UtilityClass
public class GlobalConstants {

  public final static String PROPERTY_NAME = "config.properties";

  public final static String HEART_MASSAGE = "Heart Massage";
  public final static String STOP_BLEEDING = "Stop Bleeding";
  public final static String HEIMLICH_MANEUVER = "Heimlich Maneuver";
  public final static String ARTIFICIAL_RESPIRATION = "Artificial Respiration";
  public final static String FAINTING = "Fainting";
  public final static String SUN_STROKE = "Sun Stroke";

  public final static String IMAGES_PATH_TEMPLATE = "src/main/resources/images/%s.jpg";
  public final static String FILE_PATH_TEMPLATE = "src/main/resources/guides/%s.txt";

  public final static List<String> CORRECT_BUTTONS = new ArrayList<String>() {{
    add(HEART_MASSAGE);
    add(STOP_BLEEDING);
    add(HEIMLICH_MANEUVER);
    add(ARTIFICIAL_RESPIRATION);
    add(FAINTING);
    add(SUN_STROKE);
  }};

}
