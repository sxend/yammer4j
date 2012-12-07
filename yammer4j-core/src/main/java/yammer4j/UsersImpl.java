package yammer4j;

class UsersImpl implements Users {
    private final YammerHttpClient yammerHttpClient;

    UsersImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
