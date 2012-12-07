package yammer4j;

import yammer4j.exception.YammerException;
import yammer4j.response.*;
import yammer4j.response.Error;

/**
 * @deprecated
 */
public interface OAuthImpersonation {
    public Response<AccessToken, yammer4j.response.Error> getToken(String userId, String consumerKey) throws YammerException;
    public Response<AccessToken,Error> getPreAuthorizedToken(String userId, String consumerKey) throws YammerException ;
    public static final String OAUTH_TOKENS = ApiUrl.API_BASE_URL + "/oauth/tokens";
    public static final String OAUTH = ApiUrl.API_BASE_URL + "/oauth";
}
