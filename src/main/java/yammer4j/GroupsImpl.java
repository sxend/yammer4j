package yammer4j;


class GroupsImpl implements Groups {
    private final YammerHttpClient yammerHttpClient;

    GroupsImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
