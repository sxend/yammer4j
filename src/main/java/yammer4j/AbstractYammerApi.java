package yammer4j;

abstract class AbstractYammerApi {

    final YammerHttpClient client;

    AbstractYammerApi(YammerHttpClient client) {
        this.client = client;
    }

}
