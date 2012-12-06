package yammer4j;

/**
 * @deprecated
 */
class OAuthImpersonationImpl implements OAuthImpersonation {
    private final YammerHttpClient yammerHttpClient;

    OAuthImpersonationImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
