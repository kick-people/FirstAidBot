import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import core.bot.Bot;
import core.design.ReplyKeyboardMarkup;
import lombok.extern.log4j.Log4j;

/**
 * Created by Vitalii_Strieltsov on 11/15/2018
 */
@Log4j
public class RunBot {

  public static void main(String[] args) {
    ApiContextInitializer.init();
    TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
    try {
      telegramBotsApi.registerBot(new Bot());
    } catch (TelegramApiRequestException e) {
      log.error("Exception: " + e.getMessage());
    }
  }

}
