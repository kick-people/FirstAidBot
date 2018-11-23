package core.rest.consumer;

import core.utils.FileUtils;
import core.utils.session.Key;
import core.utils.session.Session;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;

/**
 * Created by Vitalii_Strieltsov on 11/19/2018
 */
public class HeartMassageConsumer extends BaseConsumer {

  private String searchQuery;

  HeartMassageConsumer(String searchQuery) {
    this.searchQuery = searchQuery;
  }

  public HeartMassageConsumer getContentByQuery() {
    uriBuilder.addParameter("titles", searchQuery);
    String response = FileUtils.fileReader(searchQuery.replace(SPACE, EMPTY).toLowerCase());
    Session.putDataInSession(Key.HEART_MASSAGE, response);
    /*String response = client.get(uriBuilder.toString());
    AnswerSearchByQueryDto partSelector = new Gson().fromJson(new JsonParser().parse(response).getAsJsonObject(), AnswerSearchByQueryDto.class);
    Session.putDataInSession(Key.HEART_MASSAGE, partSelector.getQuery().getExtract());*/
    return this;
  }

  public String get(){
    return (String) Session.get(Key.HEART_MASSAGE);
  }

}
