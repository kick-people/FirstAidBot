package core.rest.consumer;

import org.apache.http.client.utils.URIBuilder;

import core.rest.http.RestClient;
import core.utils.config.GlobalConfig;

/**
 * Created by Vitalii_Strieltsov on 11/19/2018
 */
abstract class BaseConsumer<T> {

  RestClient client = new RestClient(GlobalConfig.getGlobalConfig().getBaseUrlApi());
  URIBuilder uriBuilder = new URIBuilder().
      addParameter("format", "json").
      addParameter("action", "query").
      addParameter("prop", "extracts").
      addParameter("redirects", "true");

  public abstract T getContentByQuery();
  public abstract String get();
}
