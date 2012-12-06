package yammer4j;

import yammer4j.exception.YammerException;
import yammer4j.response.*;
import yammer4j.response.Error;

public interface Auth {

    public Response<AuthorizationUrl, Error> getAuthorizationUrl(String clientId, String redirectUrl, boolean tokenType) throws YammerException;

    public Response<AccessToken,Error> getAccessToken(String clientId, String clientSecret, String code) throws YammerException;

    public static final String OAUTH_DIALOG = ApiUrl.YAMMER_URL + "/dialog/oauth";
    public static final String OAUTH2_ACCESS_TOKEN = ApiUrl.YAMMER_URL + "/oauth2/access_token";

}
