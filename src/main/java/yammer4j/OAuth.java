package yammer4j;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import yammer4j.exception.YammerException;
import yammer4j.obj.AuthorizedKeySet;
import yammer4j.obj.ConsumerKeyPair;
import yammer4j.obj.UnAuthorizedKeySet;

public interface OAuth {

    public static final String REQUEST_TOKEN_URL = "https://www.yammer.com/oauth/request_token";
    public static final String ACCESS_TOKEN_URL = "https://www.yammer.com/oauth/access_token";
    public static final String AUTHORIZE_URL = "https://www.yammer.com/oauth/authorize";
    public static final String AUTHORIZE_HEADER = "Authorization";
    public static final String AUTHORIZE_HEADER_PREFIX = "OAuth ";
    public static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    // private static final String OAUTH_CONSUMER_KEY_SECRET = "oauth_consumer_key_secret";
    public static final String OAUTH_TIMESTAMP = "oauth_timestamp";
    public static final String OAUTH_NONCE = "oauth_nonce";
    public static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    public static final String OAUTH_SIGNATURE = "oauth_signature";
    public static final String OAUTH_TOKEN = "oauth_token";
    // private static final String OAUTH_TOKEN_SECRET = "oauth_token_secret";
    public static final String OAUTH_VERIFIER = "oauth_verifier";

    public AuthorizedKeySet accessToken(String oAuthVerifier,UnAuthorizedKeySet unAuthorizedKeySet) throws ClientProtocolException, IOException;

    public UnAuthorizedKeySet requestToken(ConsumerKeyPair consumerKeyPair) throws YammerException, ParseException, IOException;

    public String getAuthorizedUrl(UnAuthorizedKeySet unAuthorizedKeySet);
}
