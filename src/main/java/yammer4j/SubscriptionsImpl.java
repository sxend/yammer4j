package yammer4j;

class SubscriptionsImpl implements Subscriptions {
    private final YammerHttpClient yammerHttpClient;

    SubscriptionsImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
