package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
public class RelationshipsImpl implements Relationships {
    private final YammerHttpClient yammerHttpClient;
    public RelationshipsImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
