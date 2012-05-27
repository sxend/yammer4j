package yammer4j;

import java.io.IOException;
import java.util.Calendar;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import yammer4j.object.OAuthTokenPair;
import yammer4j.util.RegexUtil;

public final class Yammer {

	private static final String YAMMER_URL = "https://www.yammer.com";
	public static final String YAMMER_API_BASE_URL = YAMMER_URL + "/api/v1";

	public static final String REQUEST_TOKEN_URL = "https://www.yammer.com/oauth/request_token";
	public static final String ACCESS_TOKEN_URL = "https://www.yammer.com/oauth/access_token";
	public static final String AUTHORIZE_URL = "https://www.yammer.com/oauth/authorize";

	public static final OAuthApi oauth = initOAuthApi();

	private static OAuthApi initOAuthApi() {
		return new OAuthApiImpl();
	}

	private OAuthTokenPair oAuthTokenPair = null;

	private String oAuthSignature = null;
	private String consumerKey;

	public final void initYammer(String oAuthVerifier)
			throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(ACCESS_TOKEN_URL);
		StringBuilder header = new StringBuilder();
		header.append("OAuth oauth_consumer_key=").append(this.consumerKey)
				.append(",oauth_token=").append(this.oAuthTokenPair.getOAuthToken())
				.append(",oauth_signature_method=").append("PLAINTEXT")
				.append(",oauth_timestamp=")
				.append(Calendar.getInstance().getTimeInMillis())
				.append(",oauth_nonce=").append(((int) (Math.random() * 1000)))
				.append(",oauth_verifier=").append(oAuthVerifier)
				.append(",oauth_signature=").append(this.oAuthSignature)
				.append(this.oAuthTokenPair.getOAuthTokenSecret());
		httpPost.setHeader("Authorization", header.toString());

		HttpResponse httpResponse = YammerHttpClient.request(httpPost);
	}

	public static final Yammer getYammer(String consumerKey,
			String consumerKeySecret) throws ParseException, IOException {
		HttpPost httpPost = new HttpPost(REQUEST_TOKEN_URL);
		StringBuilder header = new StringBuilder();
		header.append("OAuth oauth_consumer_key=").append(consumerKey)
				.append(",oauth_signature_method=PLAINTEXT,oauth_timestamp=")
				.append(Calendar.getInstance().getTimeInMillis())
				.append(",oauth_nonce=").append(((int) (Math.random() * 1000)))
				.append(",oauth_signature=").append(consumerKeySecret)
				.append("%26");
		httpPost.setHeader("authorization", header.toString());

		HttpResponse httpResponse = YammerHttpClient.request(httpPost);
		String response = EntityUtils.toString(httpResponse.getEntity());

		String oAuthToken = RegexUtil.extractMatchString(
				"oauth_token=([0-9a-ZA-Z]*)", response);
		String oAuthTokenSecret = RegexUtil.extractMatchString(
				"oauth_token_secret=([0-9a-ZA-Z]*)", response);
		;

		Yammer yammer = Yammer.yammerFactory();
		yammer.setOAuthTokenPair(new OAuthTokenPair(oAuthToken,
				oAuthTokenSecret));
		yammer.setOAthSignature(consumerKeySecret + "%26");
		yammer.setConsumerKey(consumerKey);
		return yammer;
	}

	private void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;

	}

	private void setOAthSignature(String oAuthSignature) {
		this.oAuthSignature = oAuthSignature;
	}

	private static final Yammer yammerFactory() {
		return new Yammer();
	}

	private void setOAuthTokenPair(OAuthTokenPair oAuthTokenPair) {
		this.oAuthTokenPair = oAuthTokenPair;
	}

	public OAuthTokenPair getOAuthTokenPair() {
		return oAuthTokenPair;
	}
}
