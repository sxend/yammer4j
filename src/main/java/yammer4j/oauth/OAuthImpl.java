package yammer4j.oauth;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.DefaultHttpServerConnection;

public final class OAuthImpl implements OAuth {
	public Boolean setTokens(String accessToken, String accessTokenSecret) {
		return Boolean.FALSE;
	}

	public String getAuthorizeURL(String accessToken, String accessTokenSecret) {

		try {
			HttpClient httpClient = (HttpClient) new DefaultHttpServerConnection();
			httpClient.execute(null);
		} catch (ClientProtocolException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;
	}
}
