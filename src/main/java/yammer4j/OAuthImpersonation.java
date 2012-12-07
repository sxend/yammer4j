package yammer4j;

/**
 * @deprecated
 */
public interface OAuthImpersonation {
    public Response<AccessToken, Error> getToken(String userId, String consumerKey) throws YammerException;
    public Response<AccessToken,Error> getPreAuthorizedToken(String userId, String consumerKey) throws YammerException ;
    static final String OAUTH_TOKENS = ApiUrl.API_BASE_URL + "/oauth/tokens.json";
    static final String OAUTH = ApiUrl.API_BASE_URL + "/oauth.json";
}
