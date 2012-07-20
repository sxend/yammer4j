package yammer4j;

import org.apache.http.HttpResponse;


abstract class AbstractYammerApi {

	public static final String BASE_API_URL = "https://www.yammer.com/api/v1";

	protected final YammerHttpClient client;

	AbstractYammerApi(YammerHttpClient client) {
		this.client = client;
	}
	protected abstract YammerResponse parsingObject( HttpResponse httpResponse );

}
