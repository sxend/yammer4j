package yammer4j;


class InvitationsImpl implements Invitations {
    private final YammerHttpClient yammerHttpClient;

    InvitationsImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
