package yammer4j;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import yammer4j.util.RegexUtil;

import java.util.ArrayList;
import java.util.List;

class AuthImpl implements Auth {
    private final YammerHttpClient yammerHttpClient;

    AuthImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }

    public String getAuthorizationUrl(String clientId, String redirectUrl, boolean tokenType) {
        List<NameValuePair> nvpList = new ArrayList<NameValuePair>();
        nvpList.add(new BasicNameValuePair("client_id", clientId));
        nvpList.add(new BasicNameValuePair("redirect_uri", redirectUrl));
        if (tokenType) {
            nvpList.add(new BasicNameValuePair("response_type", "token"));
        }
        ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET, OAUTH_DIALOG, nvpList);
        return apiQuery.createRequestUrl();
    }

    public AccessToken getAccessToken(String clientId, String clientSecret, String code) {
        List<NameValuePair> nvpList = new ArrayList<NameValuePair>();
        nvpList.add(new BasicNameValuePair("client_id", clientId));
        nvpList.add(new BasicNameValuePair("client_secret", clientSecret));
        nvpList.add(new BasicNameValuePair("code", code));
        YammerApiResponse response = yammerHttpClient.execute(new ApiQuery(ApiQuery.Method.GET, OAUTH2_ACCESS_TOKEN, nvpList));
        String s = response.getEntityString();
        String result = RegexUtil.extract(TOKEN_REGEX_XML, response.getEntityString());
        result = result == null ? RegexUtil.extract(TOKEN_REGEX_JSON, response.getEntityString()) : result;
        return new AccessToken(result);
    }

    private static final String TOKEN_REGEX_XML = "<token>(.*?)</token>";
    private static final String TOKEN_REGEX_JSON = "\"token\":\"(.*?)\"";

}
