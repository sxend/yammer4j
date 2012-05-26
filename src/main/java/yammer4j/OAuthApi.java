package yammer4j;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface OAuthApi {

	public String getRequestTokenUrl(String consumerKey,
			String consumerKeySecret) throws ClientProtocolException,
			IOException;
}
