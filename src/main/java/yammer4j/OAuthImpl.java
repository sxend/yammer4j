package yammer4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import yammer4j.exception.YammerException;
import yammer4j.obj.AuthorizedKeySet;
import yammer4j.obj.ConsumerKeyPair;
import yammer4j.obj.TokenPair;
import yammer4j.obj.UnAuthorizedKeySet;
import yammer4j.util.RegexUtil;

final class OAuthImpl extends AbstractYammerApi implements OAuth {

	protected OAuthImpl(YammerHttpClient client) {
		super(client);
	}

	public AuthorizedKeySet accessToken(String oAuthVerifier,
			UnAuthorizedKeySet unAuthorizedKeySet) {
		AuthorizedKeySet authorizedKeySet = new AuthorizedKeySet();
		authorizedKeySet.setoAuthVerifier(oAuthVerifier);
		authorizedKeySet.setConsumerKeyPair(unAuthorizedKeySet
				.getConsumerKeyPair());
		authorizedKeySet.setTokenPair(unAuthorizedKeySet.getTokenPair());
		client.setAuthorizeElements(authorizedKeySet);
		HttpPost httpPost = new HttpPost(ACCESS_TOKEN_URL);
		HttpResponse httpResponse = null;
		String responseBody = null;
		try {
			httpResponse = client.request(httpPost);
			responseBody = EntityUtils.toString(httpResponse.getEntity());
		} catch (ParseException e) {
			throw new YammerException(e);
		} catch (IOException e) {
			throw new YammerException(e);
		}

		authorizedKeySet.getTokenPair().setToken(
				RegexUtil.regexExtraction("oauth_token=([0-9a-zA-Z]*)",
						responseBody));
		authorizedKeySet.getTokenPair().setTokenSecret(
				RegexUtil.regexExtraction("oauth_token_secret=([0-9a-zA-Z]*)",
						responseBody));
		return authorizedKeySet;
	}

	public UnAuthorizedKeySet requestToken(ConsumerKeyPair consumerKeyPair) {
		client.setAuthorizeElements(consumerKeyPair);
		HttpPost httpPost = new HttpPost(REQUEST_TOKEN_URL);
		HttpResponse httpResponse = null;
		String responseBody = null;
		try {
			httpResponse = client.request(httpPost);
			responseBody = EntityUtils.toString(httpResponse.getEntity());
		} catch (ParseException e) {
			throw new YammerException(e);
		} catch (IOException e) {
			throw new YammerException(e);
		}
		UnAuthorizedKeySet unAuthorizedKeySet = new UnAuthorizedKeySet();
		unAuthorizedKeySet.setConsumerKeyPair(consumerKeyPair);
		TokenPair tokenPair = new TokenPair();
		tokenPair.setToken(RegexUtil.regexExtraction(
				"oauth_token=([0-9a-zA-Z]*)", responseBody));
		tokenPair.setTokenSecret(RegexUtil.regexExtraction(
				"oauth_token_secret=([0-9a-zA-Z]*)", responseBody));
		unAuthorizedKeySet.setTokenPair(tokenPair);

		return unAuthorizedKeySet;

	}

	public String getAuthorizedUrl(UnAuthorizedKeySet unAuthorizedKeySet) {
		return AUTHORIZE_URL + "?" + OAUTH_TOKEN + "="
				+ unAuthorizedKeySet.getTokenPair().getToken();
	}
}
