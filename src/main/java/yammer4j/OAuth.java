package yammer4j;

public interface OAuth {

    public String getAuthorizationUrl(String clientId, String redirectUrl);

    public AccessToken getAccessToken(String clientId, String registrationUrl);

    public AccessToken getAccessToken(String clientId, String clientSecret, String authorizationCode);

}
