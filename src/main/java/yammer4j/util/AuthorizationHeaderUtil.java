package yammer4j.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BasicHeaderValueParser;

import yammer4j.object.OAuthTokenPair;

public final class AuthorizationHeaderUtil {


    private static final String sep = ",";
    private static final String eq = "=";
    private static final String amp = "%26";
    private static final String PLAINTEXT = "PLAINTEXT";
    private static final String OAuth_ = "OAuth ";
    private static final String Authorization = "Authorization";
    private static final Random nonce = new Random(System.currentTimeMillis());

    public static BasicHeader factory(String consumerKey, String consumerKeySecret) {
        StringBuilder sb = new StringBuilder(OAuth_)
        .append("oauth_consumer_key").append(eq).append(consumerKey).append(sep)
        .append("oauth_signature_method").append(eq).append(PLAINTEXT).append(sep)
        .append("oauth_timestamp").append(eq).append(System.currentTimeMillis()).append(sep)
        .append("oauth_nonce").append(eq).append(nonce.nextInt()).append(sep)
        .append("oauth_signature").append(eq).append(consumerKeySecret).append(amp);

        return new BasicHeader(Authorization, sb.toString());
    }
    public static BasicHeader factory(String consumerKey, String consumerKeySecret,String oAuthVerifier,OAuthTokenPair oAuthTokenPair){
        StringBuilder sb = new StringBuilder(OAuth_)
                .append("oauth_consumer_key").append(eq).append(consumerKey).append(sep)
                .append("oauth_token").append(eq).append(oAuthTokenPair.getOAuthToken()).append(sep)
                .append("oauth_signature_method").append(eq).append(PLAINTEXT).append(sep)
                .append("oauth_timestamp").append(eq).append(System.currentTimeMillis()).append(sep)
                .append("oauth_nonce").append(eq).append(nonce.nextInt()).append(sep)
                .append("oauth_verifier").append(eq).append(oAuthVerifier).append(sep)
                .append("oauth_signature").append(eq).append(consumerKeySecret).append(amp).append(oAuthTokenPair.getOAuthTokenSecret());
        HttpUriRequest httpPost =new HttpPost();
        httpPost.addHeader("", "");
        return new BasicHeader(Authorization, sb.toString());
    }



}
