package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 */
public class YammerImpl implements Yammer {
    YammerImpl(){}

    private final YammerHttpClient yammerHttpClient = YammerHttpClient.getInstance();

    public final AutoComplete autocomplete = new AutoCompleteImpl(yammerHttpClient);
    public final Groups groups = new GroupsImpl(yammerHttpClient) ;
    public final Invitations invitations = new  InvitationsImpl(yammerHttpClient);
    public final Messages messages =new MessagesImpl(yammerHttpClient);
    public final Networks networks = new NetWorksImpl(yammerHttpClient);
    public final Notifications notifications = new NotificationsImpl(yammerHttpClient);
    public final OAuth oAuth = new OAuthImpl(yammerHttpClient);
    public final OAuthImpersonation oAuthImpersonation = new OAuthImpersonationImpl(yammerHttpClient);
    public final Relationships relationships=new RelationshipsImpl(yammerHttpClient);
    public final Search search = new SearchImpl(yammerHttpClient);
    public final Subscriptions subscriptions = new SubscriptionsImpl(yammerHttpClient);
    public final Suggestions suggestions = new SuggestionsImpl(yammerHttpClient);
    public final Users users = new UsersImpl(yammerHttpClient);

    AccessToken accessToken;
    public Yammer setAccessToken(AccessToken accessToken) {
        yammerHttpClient.setAccessToken(accessToken);
        return this;
    }
    public Yammer setResponseType(ResponseType responseType){
        yammerHttpClient.setResponseType(responseType);
        return this;
    }
}
