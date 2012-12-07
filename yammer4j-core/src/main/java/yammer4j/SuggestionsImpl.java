package yammer4j;

class SuggestionsImpl implements Suggestions {
    private final YammerHttpClient yammerHttpClient;

    SuggestionsImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
