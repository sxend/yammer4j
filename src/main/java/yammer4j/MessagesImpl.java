package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
public class MessagesImpl implements Messages {
    private final YammerHttpClient yammerHttpClient;
    public MessagesImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }


}