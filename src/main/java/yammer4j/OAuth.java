package yammer4j;

public interface OAuth {

    public String getAuthorizationUrl(String clientId, String redirectUrl) throws YammerException;
    public AccessToken getAccessToken(String clientId, String registrationUrl) throws YammerException;
    public AccessToken getAccessToken(String clientId, String clientSecret, String authorizationCode) throws YammerException;

}
