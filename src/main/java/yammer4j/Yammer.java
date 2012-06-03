package yammer4j;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import yammer4j.exception.YammerException;

public final class Yammer {

    public static final String YAMMER_URL = "https://www.yammer.com";
    public static final String YAMMER_API_BASE_URL = YAMMER_URL + "/api/v1";

    public final OAuth oAuth;
    public final Users users;
    public final Messages messages;
    public final Groups groups;
    public final Likes likes;
    private final YammerHttpClient client;


    private Yammer() {
        this.client= new YammerHttpClient();
        this.oAuth = oAuthFactory();
        this.users = usersFactory();
        this.messages = messagesFactory();
        this.groups = groupsFactory();
        this.likes = likesFactory();
    }

    private Likes likesFactory() {
        return new LikesImpl(client);
    }
    private Groups groupsFactory() {
        return new GroupsImpl(client);
    }
    public void initAuthorizeElements(String consumerKey, String consumerKeySecret,String oAuthVerifier,String oAuthToken,String oAuthTokenSecret){
        this.client.initAuthorizeElements(consumerKey, consumerKeySecret, oAuthVerifier, oAuthToken, oAuthTokenSecret);
    }

    public static final Yammer getYammer() {
        return new Yammer();
    }

    private final OAuth oAuthFactory() {
        return new OAuthImpl(client);
    }

    private final Users usersFactory() {
        return new UsersImpl(client);
    }
    private final Messages messagesFactory() {
        return new MessagesImpl(client);
    }
}
