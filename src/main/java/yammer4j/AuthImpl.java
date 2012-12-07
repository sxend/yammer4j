package yammer4j;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

class AuthImpl implements Auth {
    private final YammerHttpClient yammerHttpClient;

    AuthImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }

    public String getAuthorizationUrl(String clientId, String redirectUrl, boolean tokenType) {
        List<NameValuePair> nvpList = new ArrayList<NameValuePair>(3);
        nvpList.add(new BasicNameValuePair("client_id", clientId));
        nvpList.add(new BasicNameValuePair("redirect_uri", redirectUrl));
        if (tokenType) {
            nvpList.add(new BasicNameValuePair("response_type", "token"));
        }
        ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET, Auth.OAUTH_DIALOG, nvpList);
        return apiQuery.createRequestUrl();
    }

    public Response<AccessToken,Error> getAccessToken(String clientId, String clientSecret, String code) throws YammerException {
        List<NameValuePair> nvpList = new ArrayList<NameValuePair>(3);
        nvpList.add(new BasicNameValuePair("client_id", clientId));
        nvpList.add(new BasicNameValuePair("client_secret", clientSecret));
        nvpList.add(new BasicNameValuePair("code", code));
        YammerHttpResponse response = yammerHttpClient.execute(new ApiQuery(ApiQuery.Method.GET, Auth.OAUTH2_ACCESS_TOKEN, nvpList));

        return new YammerResponse<AccessToken>(new ResponseFactory<AccessToken>(response) {
            public AccessToken onSuccess() {
                String token = RegexUtil.extract(TOKEN_REGEX_JSON, this.getResponse().getEntityString());
                return new AccessToken(token);
            }
        });

    }

    private static final String TOKEN_REGEX_JSON = "\"token\":\"(.*?)\"";

}
