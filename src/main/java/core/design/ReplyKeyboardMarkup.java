package core.design;

import core.utils.session.Key;
import core.utils.session.Session;

import static core.utils.constants.GlobalConstants.ARTIFICIAL_RESPIRATION;
import static core.utils.constants.GlobalConstants.FAINTING;
import static core.utils.constants.GlobalConstants.HEART_MASSAGE;
import static core.utils.constants.GlobalConstants.HEIMLICH_MANEUVER;
import static core.utils.constants.GlobalConstants.STOP_BLEEDING;
import static core.utils.constants.GlobalConstants.SUN_STROKE;

/**
 * Created by Vitalii_Strieltsov on 11/15/2018
 */
public class ReplyKeyboardMarkup extends Keyboard {

  public static void setUpReplyKeyboard() {
    firstKeyboardRow.add(HEART_MASSAGE);
    firstKeyboardRow.add(STOP_BLEEDING);
    firstKeyboardRow.add(HEIMLICH_MANEUVER);
    secondKeyboardRow.add(ARTIFICIAL_RESPIRATION);
    secondKeyboardRow.add(FAINTING);
    secondKeyboardRow.add(SUN_STROKE);
    keyboard.add(firstKeyboardRow);
    keyboard.add(secondKeyboardRow);
    replyKeyboardMarkup.setKeyboard(keyboard);
    Session.putDataInSession(Key.REPLY_KEYBOARD_MARKUP, replyKeyboardMarkup);
  }
}
