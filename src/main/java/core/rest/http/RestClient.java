package core.rest.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

import lombok.extern.log4j.Log4j;

/**
 * Created by Vitalii_Strieltsov on 11/19/2018
 */
@Log4j
public class RestClient {

  private HttpClient httpClient = HttpClientBuilder.create().build();
  private String baseUrl;

  public RestClient(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public String get(String url) {
    String responseString;
    log.info("Send GET request to " + url);
    HttpUriRequest request = new HttpGet(baseUrl + url);

    try {
      return IOUtils.toString(httpClient.execute(request).getEntity().getContent(), StandardCharsets.UTF_8.name());
    } catch (IOException e) {
      log.error("Can not execute request. HTTP method: GET, URL: " + baseUrl + url, e);
      throw new UncheckedIOException(e);
    }
  }

}
