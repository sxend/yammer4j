package yammer4j;

class NetWorksImpl implements Networks {
    private final YammerHttpClient yammerHttpClient;

    NetWorksImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
