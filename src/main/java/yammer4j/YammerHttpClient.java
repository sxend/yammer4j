package yammer4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

class YammerHttpClient {

    private class OAuthHeaderValueMap extends HashMap<String, String> {
        String getkeyEqValue(String key) {
            String value = super.get(key);
            if (value != null && !"".equals(value)) {
                return key + "=" + value;
            }
            return "";
        }
    }

    public static final String AUTHORIZE_HEADER = "Authorization";
    private static final String AUTHORIZE_HEADER_PREFIX = "OAuth ";
    public static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    public static final String OAUTH_TOKEN = "oauth_token";
    public static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    public static final String OAUTH_TIMESTAMP = "oauth_timestamp";
    public static final String OAUTH_NONCE = "oauth_nonce";
    public static final String OAUTH_VERIFIER = "oauth_verifier";
    public static final String OAUTH_SIGNATURE = "oauth_signature";
    private final HttpClient httpClient = new DefaultHttpClient();
    private final Random random = new Random(System.currentTimeMillis());

    private final OAuthHeaderValueMap map = new OAuthHeaderValueMap();
    private String consumerKey;
    private String consumerKeySecret;
    private String oAuthVerifier;
    private String oAuthToken;

    private String oAuthTokenSecret;

    private void addAuthorizationHeader(HttpUriRequest httpUriRequest) {

    }

    void initAuthorizeElements(String consumerKey, String consumerKeySecret, String oAuthVerifier, String oAuthToken, String oAuthTokenSecret) {

        this.consumerKey = consumerKey;
        this.consumerKeySecret = consumerKeySecret;
        this.oAuthVerifier = oAuthVerifier;
        this.oAuthToken = oAuthToken;
        this.oAuthTokenSecret = oAuthTokenSecret;
    }

    private int nextNonce() {
        return random.nextInt();
    }

    HttpResponse request(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {
        addAuthorizationHeader(httpUriRequest);
        return httpClient.execute(httpUriRequest);
    }

    void setAuthorizeElements(String key, String value) {

    }
}
