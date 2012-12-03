package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
class NetWorksImpl implements Networks {
    private final YammerHttpClient yammerHttpClient;

    NetWorksImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
