package yammer4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class OAuthApiImpl implements OAuthApi {

	OAuthApiImpl() {

	}

	public String getRequestTokenUrl(String consumerKey,
			String consumerKeySecret) throws ClientProtocolException,
			IOException {
		HttpPost httpPost = new HttpPost(Yammer.YAMMER_BASE_URL
				+ "/oauth/request_token");
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = httpClient.execute(httpPost);
		return String.valueOf(httpResponse.getStatusLine().getStatusCode());
	}

}
