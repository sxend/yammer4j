package yammer4j;

abstract class AbstractYammerApi {

    public static final String BASE_API_URL="https://www.yammer.com/api/v1";

    final YammerHttpClient client;

    AbstractYammerApi(YammerHttpClient client) {
        this.client = client;
    }

}
