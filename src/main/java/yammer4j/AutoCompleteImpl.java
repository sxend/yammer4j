package yammer4j;


class AutoCompleteImpl implements AutoComplete {
    private final YammerHttpClient yammerHttpClient;

    AutoCompleteImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
