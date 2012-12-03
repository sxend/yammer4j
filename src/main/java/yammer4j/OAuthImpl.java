package yammer4j;

class OAuthImpl implements OAuth {
    private final YammerHttpClient yammerHttpClient;

    OAuthImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }

    public String getAuthorizationUrl(String clientId, String redirectUrl) {
        return null;
    }

    public AccessToken getAccessToken(String clientId, String registrationUrl) {
        return null;
    }

    public AccessToken getAccessToken(String clientId, String clientSecret, String authorizationCode) {
        return null;
    }

}
