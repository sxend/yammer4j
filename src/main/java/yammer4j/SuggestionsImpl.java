package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public class SuggestionsImpl implements Suggestions {
    private final YammerHttpClient yammerHttpClient;
    public SuggestionsImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }
}
