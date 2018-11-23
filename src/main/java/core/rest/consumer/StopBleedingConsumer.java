package core.rest.consumer;

import core.utils.FileUtils;
import core.utils.session.Key;
import core.utils.session.Session;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;

/**
 * Created by Vitalii_Strieltsov on 11/22/2018
 */
public class StopBleedingConsumer extends BaseConsumer {

  private String searchQuery;

  StopBleedingConsumer(String searchQuery) {
    this.searchQuery = searchQuery;
  }

  public StopBleedingConsumer getContentByQuery() {
    uriBuilder.addParameter("titles", searchQuery);
    String response = FileUtils.fileReader(searchQuery.replace(SPACE, EMPTY).toLowerCase());
    Session.putDataInSession(Key.STOP_BLEEDING, response);
    /*String response = client.get(uriBuilder.toString());
    AnswerSearchByQueryDto partSelector = new Gson().fromJson(new JsonParser().parse(response).getAsJsonObject(), AnswerSearchByQueryDto.class);
    Session.putDataInSession(Key.STOP_BLEEDING, partSelector.getQuery().getExtract());*/
    return this;
  }

  public String get(){
    return (String) Session.get(Key.STOP_BLEEDING);
  }

}
