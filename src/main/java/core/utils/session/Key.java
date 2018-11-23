package core.utils.session;

/**
 * Created by Vitalii_Strieltsov on 11/15/2018
 */
public enum Key {

  REPLY_KEYBOARD_MARKUP("ReplyKeyboardMarkup"),
  HEART_MASSAGE("HeartMassage"),
  STOP_BLEEDING("StopBleeding"),
  HEIMLICH_MANEUVER("HeimlichManeuver"),
  ARTIFICIAL_RESPIRATION("ArtificialRespiration"),
  FAINTING("Fainting"),
  MESSAGE_WITH_PHOTO("MessageWithPhoto"),
  SUN_STROKE("SunStroke");



  private final String text;

  /**
   * Provides a string representation of given enumeration.
   */

  Key(final String text) {
    this.text = text;
  }

  public static Key getKeyByValue(final String value) {
    Key expectedKey = null;
    for (Key key : Key.values()) {
      if (key.toString().equals(value)) {
        expectedKey = key;
        break;
      }
    }
    return expectedKey;
  }

  @Override
  public String toString() {
    return text;
  }
}
