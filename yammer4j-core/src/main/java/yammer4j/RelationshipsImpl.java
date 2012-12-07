package yammer4j;

class RelationshipsImpl implements Relationships {
    private final YammerHttpClient yammerHttpClient;

    RelationshipsImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
