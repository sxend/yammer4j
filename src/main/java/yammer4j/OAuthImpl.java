package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
public class OAuthImpl implements OAuth {
    private final YammerHttpClient yammerHttpClient;
    OAuthImpl(YammerHttpClient yammerHttpClient){
        this.yammerHttpClient = yammerHttpClient;
    }
    public String getAuthorizationUrl(String clientId, String redirectUrl) throws YammerException {

        return null;
    }

    public AccessToken getAccessToken(String clientId, String registrationUrl) throws YammerException {
        return null;
    }

    public AccessToken getAccessToken(String clientId, String clientSecret, String authorizationCode) throws YammerException {
        return null;
    }
}
