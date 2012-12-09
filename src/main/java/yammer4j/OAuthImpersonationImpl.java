package yammer4j;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated
 */
class OAuthImpersonationImpl implements OAuthImpersonation {
    private final YammerHttpClient yammerHttpClient;

    OAuthImpersonationImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }

    public Response<AccessToken> getToken(String userId, String consumerKey)  {
        List<NameValuePair>  nameValuePairList = generate(userId,consumerKey);
        ApiQuery query = new ApiQuery(ApiQuery.Method.GET, OAuthImpersonation.OAUTH_TOKENS,nameValuePairList);
       YammerHttpResponse response =  yammerHttpClient.execute(query);
        return new  YammerResponse<AccessToken>(new ResponseFactory<AccessToken>(response) {
            @Override
            public AccessToken onSuccess() {
                String token = RegexUtil.extract(TOKEN_REGEX_XML, this.getResponse().getEntityString());
                token = token == null ? RegexUtil.extract(TOKEN_REGEX_JSON, this.getResponse().getEntityString()) : token;
                return new AccessToken(token);
            }
        });
    }

    public Response<AccessToken> getPreAuthorizedToken(String userId, String consumerKey)  {
        List<NameValuePair>  nameValuePairList = generate(userId,consumerKey);
        ApiQuery query = new ApiQuery(ApiQuery.Method.POST, OAuthImpersonation.OAUTH,nameValuePairList);
        YammerHttpResponse response =  yammerHttpClient.execute(query);
        return null;
    }
    private List<NameValuePair> generate (String userId, String consumerKey){
        List<NameValuePair>  nameValuePairList = new ArrayList<NameValuePair>(2);
        nameValuePairList.add(new BasicNameValuePair("user_id",userId));
        nameValuePairList.add(new BasicNameValuePair("consumer_key",consumerKey));
        return nameValuePairList;
    }
    private static final String TOKEN_REGEX_XML = "<token>(.*?)</token>";
    private static final String TOKEN_REGEX_JSON = "\"token\":\"(.*?)\"";
}
