package core.rest.consumer;

import core.utils.FileUtils;
import core.utils.session.Key;
import core.utils.session.Session;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;

/**
 * Created by Vitalii_Strieltsov on 11/22/2018
 */
public class HeimlichManeuverConsumer extends BaseConsumer {

  private String searchQuery;

  HeimlichManeuverConsumer(String searchQuery) {
    this.searchQuery = searchQuery;
  }

  public HeimlichManeuverConsumer getContentByQuery() {
    uriBuilder.addParameter("titles", searchQuery);
    String response = FileUtils.fileReader(searchQuery.replace(SPACE, EMPTY).toLowerCase());
    Session.putDataInSession(Key.HEIMLICH_MANEUVER, response);
    /*String response = client.get(uriBuilder.toString());
    AnswerSearchByQueryDto partSelector = new Gson().fromJson(new JsonParser().parse(response).getAsJsonObject(), AnswerSearchByQueryDto.class);
    Session.putDataInSession(Key.HEIMLICH_MANEUVER, partSelector.getQuery().getExtract());*/
    return this;
  }

  public String get(){
    return (String) Session.get(Key.HEIMLICH_MANEUVER);
  }


}
