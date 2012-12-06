package yammer4j;

@Deprecated
class OAuthImpersonationImpl implements OAuthImpersonation {
    private final YammerHttpClient yammerHttpClient;

    OAuthImpersonationImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
