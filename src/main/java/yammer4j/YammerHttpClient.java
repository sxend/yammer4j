package yammer4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

class YammerHttpClient {

	private static final HttpClient httpClient = new DefaultHttpClient();

	static HttpResponse request(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {

		return httpClient.execute(httpUriRequest);

	}


}
