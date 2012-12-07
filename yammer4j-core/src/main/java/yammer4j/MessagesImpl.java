package yammer4j;


class MessagesImpl implements Messages {
    private final YammerHttpClient yammerHttpClient;

    MessagesImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }


}
