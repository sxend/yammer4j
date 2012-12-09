package yammer4j;

/**
 * @deprecated
 */
public interface OAuthImpersonation {
    public Response<AccessToken> getToken(String userId, String consumerKey) ;
    public Response<AccessToken> getPreAuthorizedToken(String userId, String consumerKey)  ;
    static final String OAUTH_TOKENS = ApiUrl.API_BASE_URL + "/oauth/tokens.json";
    static final String OAUTH = ApiUrl.API_BASE_URL + "/oauth.json";
}
