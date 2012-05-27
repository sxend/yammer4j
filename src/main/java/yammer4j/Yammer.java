package yammer4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import yammer4j.exception.YammerException;
import yammer4j.object.AuthorizationHeaderUtil;
import yammer4j.object.OAuthTokenPair;
import yammer4j.util.RegexUtil;

public final class Yammer {

	public static final String YAMMER_URL = "https://www.yammer.com";
	public static final String YAMMER_API_BASE_URL = YAMMER_URL + "/api/v1";

	public static final String REQUEST_TOKEN_URL = "https://www.yammer.com/oauth/request_token";
	public static final String ACCESS_TOKEN_URL = "https://www.yammer.com/oauth/access_token";
	public static final String AUTHORIZE_URL = "https://www.yammer.com/oauth/authorize";


	private OAuthTokenPair oAuthTokenPair = null;
	private String consumerKey = null;
	private String consumerKeySecret = null;


	private boolean authorized = false;


	public final void verify(String oAuthVerifier)
			throws ClientProtocolException, IOException, YammerException {
		HttpPost httpPost = new HttpPost(ACCESS_TOKEN_URL);
		BasicHeader basicHeader = AuthorizationHeaderUtil.factory(consumerKey,consumerKeySecret,oAuthVerifier,oAuthTokenPair);
        httpPost.addHeader(basicHeader);

		HttpResponse httpResponse = YammerHttpClient.request(httpPost);

		if(httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK){
		    throw new YammerException("Authorization Failed");
		}

		this.authorized = true;


	}

	public static final Yammer getYammer(String consumerKey,
			String consumerKeySecret) throws ParseException, IOException {
		HttpPost httpPost = new HttpPost(REQUEST_TOKEN_URL);

		BasicHeader basicHeader = AuthorizationHeaderUtil.factory(consumerKey,consumerKeySecret);
		httpPost.addHeader(basicHeader);

		HttpResponse httpResponse = YammerHttpClient.request(httpPost);
		String response = EntityUtils.toString(httpResponse.getEntity());

		String oAuthToken = RegexUtil.regexExtraction(
				"oauth_token=([0-9a-ZA-Z]*)", response);

		String oAuthTokenSecret = RegexUtil.regexExtraction(
				"oauth_token_secret=([0-9a-ZA-Z]*)", response);


		Yammer yammer = Yammer.yammerFactory();
		yammer.setOAuthTokenPair(new OAuthTokenPair(oAuthToken,
				oAuthTokenSecret));

		yammer.setConsumerKey(consumerKey);
		yammer.setConsumerKeySecret(consumerKeySecret);
		yammer.authorized = false;
		return yammer;
	}

	public boolean isAuthorized(){
	    return this.authorized;
	}
	private void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;

	}
	private void setConsumerKeySecret(String consumerKeySecret) {
        this.consumerKeySecret = consumerKeySecret;

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
