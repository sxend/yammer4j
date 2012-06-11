package yammer4j;

import java.io.IOException;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import yammer4j.obj.AuthorizedKeySet;
import yammer4j.obj.ConsumerKeyPair;
import yammer4j.obj.TokenPair;

class YammerHttpClient {

	private final HttpClient httpClient = new DefaultHttpClient();
	private String consumerKey;
	private String consumerKeySecret;
	private String oAuthVerifier;
	private String token;
	private String tokenSecret;
	private Random random = new Random(System.currentTimeMillis());

	YammerHttpClient() {
	}

	YammerHttpClient(AuthorizedKeySet authorizedKeySet) {
		this.consumerKey = authorizedKeySet.getConsumerKeyPair()
				.getConsumerKey();
		this.consumerKeySecret = authorizedKeySet.getConsumerKeyPair()
				.getConsumerKeySecret();
		this.oAuthVerifier = authorizedKeySet.getoAuthVerifier();
		this.token = authorizedKeySet.getTokenPair().getToken();
		this.tokenSecret = authorizedKeySet.getTokenPair().getTokenSecret();
	}

	private void addAuthorizationHeader(HttpUriRequest httpUriRequest) {
		httpUriRequest.addHeader(OAuth.AUTHORIZE_HEADER,
				generateAuthHeaderValue());
	}

	private String generateAuthHeaderValue() {
		AuthHeaderAppender authHeaderAppender = new AuthHeaderAppender(
				OAuth.AUTHORIZE_HEADER_PREFIX);
		authHeaderAppender.append(getConsumerKeyHeader())
				.append(getTokenHeader()).append(getSignatureMethodHeader())
				.append(getTimeStampHeader()).append(getNonceHeader())
				.append(getVerifierHeader()).append(getSignatureHeader());
		System.out.println(authHeaderAppender.getAuthHeaderValue());
		return authHeaderAppender.getAuthHeaderValue();

	}

	private String getConsumerKeyHeader() {
		return strEqJoin(OAuth.OAUTH_CONSUMER_KEY, this.consumerKey);
	}

	private String getSignatureMethodHeader() {
		return strEqJoin(OAuth.OAUTH_SIGNATURE_METHOD, "PLAINTEXT");
	}

	private String getNonceHeader() {
		return strEqJoin(OAuth.OAUTH_NONCE, String.valueOf(random.nextInt()));
	}

	private String getSignatureHeader() {
		StringBuilder signature = null;
		if (this.consumerKeySecret != null) {
			signature = new StringBuilder(this.consumerKeySecret).append("%26");
			if (this.tokenSecret != null) {
				signature.append(this.tokenSecret);
			}
		}
		return strEqJoin(OAuth.OAUTH_SIGNATURE, signature.toString());
	}

	private String getTimeStampHeader() {
		return strEqJoin(OAuth.OAUTH_TIMESTAMP,
				String.valueOf(System.currentTimeMillis()));
	}

	private String getVerifierHeader() {

		return strEqJoin(OAuth.OAUTH_VERIFIER, this.oAuthVerifier);
	}

	private String getTokenHeader() {

		return strEqJoin(OAuth.OAUTH_TOKEN, this.token);
	}

	private String strEqJoin(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return null;
		}
		return new StringBuilder(str1).append("=").append(str2).toString();
	}

	HttpResponse request(HttpUriRequest httpUriRequest)
			throws ClientProtocolException, IOException {
		addAuthorizationHeader(httpUriRequest);
		return httpClient.execute(httpUriRequest);

	}

	void setAuthorizeElements(ConsumerKeyPair consumerKeyPair) {
		AuthorizedKeySet authorizedKeySet = new AuthorizedKeySet();
		authorizedKeySet.setConsumerKeyPair(consumerKeyPair);
		authorizedKeySet.setTokenPair(new TokenPair());
		setAuthorizeElements(authorizedKeySet);
	}

	void setAuthorizeElements(AuthorizedKeySet authorizedKeySet) {
		this.consumerKey = authorizedKeySet.getConsumerKeyPair()
				.getConsumerKey();
		this.consumerKeySecret = authorizedKeySet.getConsumerKeyPair()
				.getConsumerKeySecret();
		this.oAuthVerifier = authorizedKeySet.getoAuthVerifier();
		this.token = authorizedKeySet.getTokenPair().getToken();
		this.tokenSecret = authorizedKeySet.getTokenPair().getTokenSecret();
	}

	class AuthHeaderAppender {
		StringBuilder sb;

		boolean commaFlg = false;

		AuthHeaderAppender append(String headerElement) {
			if (headerElement != null) {
				if (commaFlg) {
					sb.append(",");
				}
				sb.append(headerElement);
				commaFlg = true;
			}
			return this;
		}

		AuthHeaderAppender(String headerPrifix) {
			sb = new StringBuilder(headerPrifix);
		}

		String getAuthHeaderValue() {
			return sb.toString();
		}

	}

}
