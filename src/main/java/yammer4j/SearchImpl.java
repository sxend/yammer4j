package yammer4j;

class SearchImpl implements Search {
    private final YammerHttpClient yammerHttpClient;

    SearchImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
