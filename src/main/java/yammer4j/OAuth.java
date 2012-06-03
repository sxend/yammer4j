package yammer4j;

import yammer4j.exception.YammerException;

interface OAuth {

    public static final String REQUEST_TOKEN_URL = "https://www.yammer.com/oauth/request_token";
    public static final String ACCESS_TOKEN_URL = "https://www.yammer.com/oauth/access_token";
    public static final String AUTHORIZE_URL = "https://www.yammer.com/oauth/authorize";

    public String accessToken(String oAuthVerifier);

    public String requestToken(String consumerKey, String consumerKeySecret) throws YammerException;
}
