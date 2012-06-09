package yammer4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import yammer4j.obj.AuthorizedKeySet;
import yammer4j.obj.ConsumerKeyPair;
import yammer4j.obj.TokenPair;
import yammer4j.obj.UnAuthorizedKeySet;
import yammer4j.util.RegexUtil;

final class OAuthImpl extends AbstractYammerApi
        implements OAuth {

    protected OAuthImpl(YammerHttpClient client) {
        super(client);
    }

    public AuthorizedKeySet accessToken(String oAuthVerifier, UnAuthorizedKeySet unAuthorizedKeySet) throws ClientProtocolException, IOException {
        AuthorizedKeySet authorizedKeySet = new AuthorizedKeySet();
        authorizedKeySet.setoAuthVerifier(oAuthVerifier);
        authorizedKeySet.setConsumerKeyPair(unAuthorizedKeySet.getConsumerKeyPair());
        authorizedKeySet.setTokenPair(unAuthorizedKeySet.getTokenPair());
        client.setAuthorizeElements(authorizedKeySet);
        HttpPost httpPost = new HttpPost(ACCESS_TOKEN_URL);
        HttpResponse httpResponse = client.request(httpPost);
        String responseBody = EntityUtils.toString(httpResponse.getEntity());

        authorizedKeySet.getTokenPair().setToken(RegexUtil.regexExtraction("oauth_token=([0-9a-zA-Z]*)", responseBody));
        authorizedKeySet.getTokenPair().setTokenSecret(RegexUtil.regexExtraction("oauth_token_secret=([0-9a-zA-Z]*)", responseBody));
        return authorizedKeySet;
    }

    public UnAuthorizedKeySet requestToken(ConsumerKeyPair consumerKeyPair) throws ParseException, IOException {
        client.setAuthorizeElements(consumerKeyPair);
        HttpPost httpPost = new HttpPost(REQUEST_TOKEN_URL);
        HttpResponse httpResponse = client.request(httpPost);
        String responseBody = EntityUtils.toString(httpResponse.getEntity());
        UnAuthorizedKeySet unAuthorizedKeySet = new UnAuthorizedKeySet();
        unAuthorizedKeySet.setConsumerKeyPair(consumerKeyPair);
        TokenPair tokenPair = new TokenPair();
        tokenPair.setToken(RegexUtil.regexExtraction("oauth_token=([0-9a-zA-Z]*)", responseBody));
        tokenPair.setTokenSecret(RegexUtil.regexExtraction("oauth_token_secret=([0-9a-zA-Z]*)", responseBody));
        unAuthorizedKeySet.setTokenPair(tokenPair);

        return unAuthorizedKeySet;

    }

    public String getAuthorizedUrl(UnAuthorizedKeySet unAuthorizedKeySet){
        return AUTHORIZE_URL+"?"+ OAUTH_TOKEN +"="+unAuthorizedKeySet.getTokenPair().getToken();
    }
}
