package httpRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/* Esta clase se encarga de realizar efectivamente el pedido de feed al servidor de noticias
 * Leer sobre como hacer una http request en java
 * https://www.baeldung.com/java-http-request
 * */

public class httpRequester {

	HttpClient client;

	public httpRequester() {
		this.client = HttpClient.newHttpClient();
	}

	public String getFeedRss(String urlFeed) {
		String feedRssXml = null;
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(urlFeed)).GET().build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			feedRssXml = response.body();
		} catch (Exception e) {
			feedRssXml = "";
		}
		return feedRssXml;
	}

	public String getFeedReddit(String urlFeed) {
		String feedRedditJson = null;
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFeed)).GET().build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			feedRedditJson = response.body();
		} catch (IOException | InterruptedException e) {
			feedRedditJson = "";
		}

		return feedRedditJson;
	}

}
