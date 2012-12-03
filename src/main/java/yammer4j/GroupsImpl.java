package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
class GroupsImpl implements Groups {
    private final YammerHttpClient yammerHttpClient;

    GroupsImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
