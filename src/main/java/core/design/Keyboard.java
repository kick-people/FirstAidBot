package core.design;

import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitalii_Strieltsov on 11/15/2018
 */
abstract class Keyboard {

  static ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup().setResizeKeyboard(true);
  static KeyboardRow firstKeyboardRow = new KeyboardRow();
  static KeyboardRow secondKeyboardRow = new KeyboardRow();
  static List<KeyboardRow> keyboard = new ArrayList<>();

}
