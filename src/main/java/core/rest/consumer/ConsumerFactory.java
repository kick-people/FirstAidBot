package core.rest.consumer;

import core.bot.Bot;
import core.utils.FileUtils;
import core.utils.constants.GlobalConstants;
import core.utils.session.Key;
import core.utils.session.Session;


import static core.utils.constants.GlobalConstants.ARTIFICIAL_RESPIRATION;
import static core.utils.constants.GlobalConstants.FAINTING;
import static core.utils.constants.GlobalConstants.HEART_MASSAGE;
import static core.utils.constants.GlobalConstants.HEIMLICH_MANEUVER;
import static core.utils.constants.GlobalConstants.STOP_BLEEDING;
import static core.utils.constants.GlobalConstants.SUN_STROKE;
import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;

/**
 * Created by Vitalii_Strieltsov on 11/19/2018
 */
public class ConsumerFactory {

  public String createConsumer(){
    return Match(Bot.getUserMessage()).of(
        Case($(HEART_MASSAGE), ()-> new HeartMassageConsumer(HEART_MASSAGE).getContentByQuery().get()),
        Case($(STOP_BLEEDING), ()-> new StopBleedingConsumer(STOP_BLEEDING).getContentByQuery().get()),
        Case($(HEIMLICH_MANEUVER), ()-> new HeimlichManeuverConsumer(HEIMLICH_MANEUVER).getContentByQuery().get()),
        Case($(ARTIFICIAL_RESPIRATION), ()-> new ArtificialRespirationConsumer(ARTIFICIAL_RESPIRATION).getContentByQuery().get()),
        Case($(FAINTING), ()-> new FaintingConsumer(FAINTING).getContentByQuery().get()),
        Case($(SUN_STROKE), ()-> new SunStrokeConsumer(SUN_STROKE).getContentByQuery().get()),
        Case($(), ()-> FileUtils.fileReader("start"))
        //Case($("/start"), "**Добро пожаловать в First Help Aid Bot!** \r\nЧтобы перезапустить бота - /start\r\nЧтобы зарегистроваться или же изменить свою анкету - /register\r\nЧтобы посмотреть количество пользователей бота - /stats\r\n По поводу возникших вопросов - @strelcov_v"),
        //Case($(), "Input correct button")
    );
  }

}
