package yammer4j;

public final class Yammer {

    public static final String YAMMER_URL = "https://www.yammer.com";
    public static final String YAMMER_API_BASE_URL = YAMMER_URL + "/api/v1";

    public static final Yammer getYammer() {
        return new Yammer();
    }
    public final OAuth oAuth;
    public final Users users;
    public final Messages messages;
    public final Groups groups;
    public final Likes likes;

    private final YammerHttpClient client;

    private Yammer() {
        this.client = new YammerHttpClient();
        this.oAuth = oAuthFactory();
        this.users = usersFactory();
        this.messages = messagesFactory();
        this.groups = groupsFactory();
        this.likes = likesFactory();
    }

    public Yammer initAuthorizeElements(String consumerKey, String consumerKeySecret, String oAuthVerifier, String oAuthToken, String oAuthTokenSecret) {
        this.client.initAuthorizeElements(consumerKey, consumerKeySecret, oAuthVerifier, oAuthToken, oAuthTokenSecret);
        return this;
    }

    private Groups groupsFactory() {
        return new GroupsImpl(this.client);
    }

    private Likes likesFactory() {
        return new LikesImpl(this.client);
    }

    private final Messages messagesFactory() {
        return new MessagesImpl(this.client);
    }

    private final OAuth oAuthFactory() {
        return new OAuthImpl(this.client);
    }

    private final Users usersFactory() {
        return new UsersImpl(this.client);
    }
}
