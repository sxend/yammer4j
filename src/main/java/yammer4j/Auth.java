package yammer4j;

public interface Auth {

    public String getAuthorizationUrl(String clientId, String redirectUrl, boolean tokenType);

    public AccessToken getAccessToken(String clientId, String clientSecret, String code);

    public static final String OAUTH_DIALOG = ApiUrl.YAMMER_URL + "/dialog/oauth";
    public static final String OAUTH2_ACCESS_TOKEN = ApiUrl.YAMMER_URL + "/oauth2/access_token";

}
