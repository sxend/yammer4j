package yammer4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class YammerHttpClient {

	static HttpResponse request(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {

		HttpClient httpClient = new DefaultHttpClient();
		return httpClient.execute(httpUriRequest);

	}


}
