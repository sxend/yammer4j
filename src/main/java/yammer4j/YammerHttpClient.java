package yammer4j;

import java.io.IOException;
import java.util.Calendar;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import yammer4j.enums.RequestType;
import yammer4j.enums.YammerApiUrl;

public class YammerHttpClient {

	static HttpResponse request(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {

		HttpClient httpClient = new DefaultHttpClient();
		return httpClient.execute(httpUriRequest);

	}
	static HttpPost defaultPostRequest(String url,String consumerKey,String consumerKeySecret){

		return null;
	}

}
