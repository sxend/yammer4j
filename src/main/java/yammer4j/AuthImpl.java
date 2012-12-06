package yammer4j;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import yammer4j.exception.YammerException;
import yammer4j.response.*;
import yammer4j.response.Error;
import yammer4j.util.RegexUtil;

import java.util.ArrayList;
import java.util.List;

class AuthImpl implements Auth {
    private final YammerHttpClient yammerHttpClient;

    AuthImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }

    public Response<AuthorizationUrl, Error> getAuthorizationUrl(String clientId, String redirectUrl, boolean tokenType) throws YammerException {
        List<NameValuePair> nvpList = new ArrayList<NameValuePair>(3);
        nvpList.add(new BasicNameValuePair("client_id", clientId));
        nvpList.add(new BasicNameValuePair("redirect_uri", redirectUrl));
        if (tokenType) {
            nvpList.add(new BasicNameValuePair("response_type", "token"));
        }
        ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET, OAUTH_DIALOG, nvpList);
        return new YammerResponse<AuthorizationUrl>(new AuthorizationUrl(apiQuery.createRequestUrl()));
    }

    public Response<AccessToken,Error> getAccessToken(String clientId, String clientSecret, String code) throws YammerException {
        List<NameValuePair> nvpList = new ArrayList<NameValuePair>(3);
        nvpList.add(new BasicNameValuePair("client_id", clientId));
        nvpList.add(new BasicNameValuePair("client_secret", clientSecret));
        nvpList.add(new BasicNameValuePair("code", code));
        YammerApiResponse response = yammerHttpClient.execute(new ApiQuery(ApiQuery.Method.GET, OAUTH2_ACCESS_TOKEN, nvpList));

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_BAD_REQUEST) {
            throw new YammerException(response.getEntityString());             //TODO
        }
        String token = RegexUtil.extract(TOKEN_REGEX_XML, response.getEntityString());
        token = token == null ? RegexUtil.extract(TOKEN_REGEX_JSON, response.getEntityString()) : token;
        return new YammerResponse<AccessToken>(new AccessToken(token));
    }

    private static final String TOKEN_REGEX_XML = "<token>(.*?)</token>";
    private static final String TOKEN_REGEX_JSON = "\"token\":\"(.*?)\"";

}
