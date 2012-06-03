package yammer4j;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;

interface OAuth {

	public static final String AUTHORIZE_HEADER="Authorization";
	public static final String AUTHORIZE_HEADER_OAUTH="OAuth ";

	public static final String OAUTH_CONSUMER_KEY="oauth_consumer_key";
	public static final String OAUTH_TOKEN="oauth_token";
	public static final String OAUTH_SIGNATURE_METHOD="oauth_signature_method";
	public static final String OAUTH_TIMESTAMP="oauth_timestamp";
	public static final String OAUTH_NONCE="oauth_nonce";
	public static final String OAUTH_VERIFIER="oauth_verifier";
	public static final String OAUTH_SIGNATURE="oauth_signature";

	public static final String REQUEST_TOKEN_URL = "https://www.yammer.com/oauth/request_token";
	public static final String ACCESS_TOKEN_URL = "https://www.yammer.com/oauth/access_token";
	public static final String AUTHORIZE_URL = "https://www.yammer.com/oauth/authorize";

	public boolean verify(String oAuthVerifier) throws ClientProtocolException, IOException;

	public HttpUriRequest addAuthorizeHeader(HttpUriRequest httpUriRequest);

	public String getAuthorizeUrl();

}
