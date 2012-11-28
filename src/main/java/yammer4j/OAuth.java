package yammer4j;

import yammer4j_old.AccessToken;

public interface OAuth {

    public AuthorizationUrl getAuthorizationUrl(String clientId, String redirectUrl);
    public AccessToken getAccessToken(String clientId, String registrationUrl);
    public Object getAccessToken(String clientId, String clientSecret, String authorizationCode);

}
