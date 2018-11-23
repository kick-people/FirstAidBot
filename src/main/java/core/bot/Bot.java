package core.bot;

import org.apache.commons.lang3.StringUtils;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;
import java.util.Objects;

import core.design.ReplyKeyboardMarkup;
import core.rest.consumer.ConsumerFactory;
import core.utils.session.Key;
import core.utils.session.Session;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import static core.utils.constants.GlobalConstants.CORRECT_BUTTONS;
import static core.utils.constants.GlobalConstants.IMAGES_PATH_TEMPLATE;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;

/**
 * Created by Vitalii_Strieltsov on 11/15/2018
 */
@Log4j
public class Bot extends TelegramLongPollingBot {

  @Getter
  private static String userMessage;

  private ConsumerFactory consumerFactory = new ConsumerFactory();

  public void onUpdateReceived(Update update) {
    userMessage = update.getMessage().getText();
    if (userMessage.equals("/start") && Objects.isNull(Session.get(Key.REPLY_KEYBOARD_MARKUP))) {
      ReplyKeyboardMarkup.setUpReplyKeyboard();
    }
    //sendLocalePhoto(update.getMessage().getChatId().toString(), userMessage);
    sendMsg(update.getMessage().getChatId().toString(), consumerFactory.createConsumer(), userMessage);
  }

  private synchronized void sendMsg(String chatId, String botMessage, String userMessage) {
    SendMessage prepareMessage =
        new SendMessage().
            setChatId(chatId).
            setText(botMessage).
            setReplyMarkup((ReplyKeyboard) Session.get(Key.REPLY_KEYBOARD_MARKUP));
    try {
      if (CORRECT_BUTTONS.stream().anyMatch(button -> button.equalsIgnoreCase(userMessage))) {
        sendLocalePhoto(chatId, userMessage);
      }
      sendMessage(prepareMessage);
    } catch (TelegramApiException e) {
      log.error("Exception: " + e.toString());
    }
  }

  private synchronized void sendLocalePhoto(String chatId, String photoName) {
    SendPhoto preparePhoto =
        new SendPhoto().setChatId(chatId).
            setNewPhoto(new File(String.format(IMAGES_PATH_TEMPLATE, photoName.replace(SPACE, EMPTY))));
    try {
      sendPhoto(preparePhoto);
    } catch (TelegramApiException e) {
      log.error("Exception: " + e.toString());
    }
  }

  public String getBotUsername() {
    return "FirstHelpAidBot";
  }

  public String getBotToken() {
    return "773017346:AAHodMcqWAxuYbwVg6tKVQTihNVZYtNonHU";
  }
}
