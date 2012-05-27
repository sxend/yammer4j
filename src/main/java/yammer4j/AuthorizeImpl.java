package yammer4j;

import java.io.IOException;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;

import yammer4j.util.RegexUtil;

public class AuthorizeImpl implements Authorize {

	// private OAuthTokenPair oAuthTokenPair = null;
	private String consumerKey = null;
	private String consumerKeySecret = null;
	private String oAuthToken = null;
	private String oAuthTokenSecret = null;
	private String signature = null;
	private String signatureMethod = "PLAINTEXT";
	private String verifier = null;
	private Random nonce = new Random(System.currentTimeMillis());

	private String authorizeUrl = null;

	AuthorizeImpl(String consumerKey, String consumerKeySecret)
			throws ClientProtocolException, IOException {
		this.consumerKey = consumerKey;
		this.consumerKeySecret = consumerKeySecret;
		this.signature = consumerKeySecret + "%26";

		HttpPost httpPost = new HttpPost(REQUEST_TOKEN_URL);
		httpPost = (HttpPost) addAuthorizeHeader(httpPost);

		HttpResponse httpResponse = YammerHttpClient.request(httpPost);
		String response = EntityUtils.toString(YammerHttpClient.request(
				httpPost).getEntity());
		this.authorizeUrl = AUTHORIZE_URL + "?" + response;
		String oAuthToken = RegexUtil.regexExtraction(
				"oauth_token=([0-9a-zA-Z]*)", response);
		this.oAuthToken = oAuthToken;
		String oAuthTokenSecret = RegexUtil.regexExtraction(
				"oauth_token_secret=([0-9a-zA-Z]*)", response);
		this.oAuthTokenSecret = oAuthTokenSecret;
		this.signature += oAuthTokenSecret;

		// this.setOAuthTokenPair(new OAuthTokenPair(oAuthToken,
		// oAuthTokenSecret));

	}

	public boolean verify(String oAuthVerifier) throws ClientProtocolException,
			IOException {

		HttpPost httpPost = new HttpPost(ACCESS_TOKEN_URL);
		httpPost = (HttpPost) addAuthorizeHeader(httpPost);
		HttpResponse httpResponse = YammerHttpClient.request(httpPost);

		return httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
	}

	public HttpUriRequest addAuthorizeHeader(HttpUriRequest httpUriRequest) {
		AuthHeaderBuilder ab = new AuthHeaderBuilder(AUTHORIZE_HEADER_OAUTH);
		ab.append(OAUTH_CONSUMER_KEY, this.consumerKey)
				.append(OAUTH_TOKEN, this.oAuthToken)
				.append(OAUTH_SIGNATURE_METHOD, this.signatureMethod)
				.append(OAUTH_VERIFIER, this.verifier)
				.append(OAUTH_TIMESTAMP,
						String.valueOf(System.currentTimeMillis()))
				.append(OAUTH_SIGNATURE, this.signature)
				.append(OAUTH_NONCE,
						String.valueOf(Math.abs(this.nonce.nextInt())));

		httpUriRequest.addHeader(AUTHORIZE_HEADER, ab.toString());
		return httpUriRequest;
	}

	public String getAuthorizeUrl() {
		return this.authorizeUrl;
	}

	private class AuthHeaderBuilder {
		StringBuilder sb;

		private AuthHeaderBuilder(String prefix) {
			this.sb = new StringBuilder(AUTHORIZE_HEADER_OAUTH);
		}

		private AuthHeaderBuilder append(String key, String value) {
			if (key != null && value != null) {
				sb.append(key).append("=").append(value).append(",");
			}
			return this;
		}

		public String toString() {
			return sb.toString();
		}
	}

}
