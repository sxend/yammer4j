package yammer4j;




public final class Yammer {

    private Yammer() {
    }

    public static Yammer getInstance() {
        return new Yammer();
    }

    private final YammerHttpClient yammerHttpClient = YammerHttpClient.getInstance();

    public final AutoComplete autoComplete = new AutoCompleteImpl(yammerHttpClient);
    public final Groups groups = new GroupsImpl(yammerHttpClient);
    public final Invitations invitations = new InvitationsImpl(yammerHttpClient);
    public final Messages messages = new MessagesImpl(yammerHttpClient);
    public final Networks networks = new NetWorksImpl(yammerHttpClient);
    public final Notifications notifications = new NotificationsImpl(yammerHttpClient);
    public final Auth auth = new AuthImpl(yammerHttpClient);
    public final OAuthImpersonation oAuthImpersonation = new OAuthImpersonationImpl(yammerHttpClient);
    public final Relationships relationships = new RelationshipsImpl(yammerHttpClient);
    public final Search search = new SearchImpl(yammerHttpClient);
    public final Subscriptions subscriptions = new SubscriptionsImpl(yammerHttpClient);
    public final Suggestions suggestions = new SuggestionsImpl(yammerHttpClient);
    public final Users users = new UsersImpl(yammerHttpClient);

    public void setAccessToken(AccessToken accessToken) {
        yammerHttpClient.setAccessToken(accessToken);
    }

}
