package yammer4j;

class NotificationsImpl implements Notifications {
    private final YammerHttpClient yammerHttpClient;

    NotificationsImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
