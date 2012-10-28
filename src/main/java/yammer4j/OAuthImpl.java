package yammer4j;

import java.util.HashMap;
import java.util.Map;


public class OAuthImpl implements OAuth {

	private YammerHttpClient client = YammerHttpClient.getClient();

	public String getRedirectUrl(String clientId, String callBackUrl) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("client_id", clientId);
		param.put("redirect_uri", callBackUrl);
		System.out.println(client);
		client.get("https://www.yammer.com/dialog/oauth",param);
		return null;
	}

	public AccessToken getToken(String clientId, String callBackUrl) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("client_id", clientId);
		param.put("redirect_uri", callBackUrl);
		param.put("response_type", "token");
		client.get("https://www.yammer.com/dialog/oauth", param);
		return null;
	}

	public AccessToken getToken(String clientId, String clientSecret,
			String code) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("client_id", clientId);
		param.put("client_secret", clientSecret);
		param.put("code", code);
		client.get("https://www.yammer.com/oauth2/access_token.json", param );
		return null;
	}

	@Deprecated
	public UnAuthorisedToken getPreAuthorizedTokenForAdmin(String userId,
			String consumerKey) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("user_id", userId);
		param.put("consumer_key", consumerKey);
		client.post("https://www.yammer.com/api/v1/oauth.json", param);
		return null;
	}
	@Deprecated
	public AccessToken getAuthorizedToken(String userId,
			String consumerKey) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("user_id", userId);
		param.put("consumer_key", consumerKey);
		System.out.println(client);
		client.get("https://www.yammer.com/api/v1/oauth/tokens.json", param);
		return null;
	}

}
