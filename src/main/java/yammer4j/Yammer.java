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

    private Yammer(String consumerKey, String consumerKeySecret) {
        this.oAuth = oAuthFactory(consumerKey, consumerKeySecret);
        this.users = usersFactory();
        this.messages = messagesFactory();
    }

    private Yammer() {
        this.oAuth = oAuthFactory();
        this.users = usersFactory();
        this.messages = messagesFactory();
    }

    public static final Yammer getYammer(String consumerKey, String consumerKeySecret) throws ParseException, IOException {
        return new Yammer(consumerKey, consumerKeySecret);
    }

    public static final Yammer getYammer() {
        return new Yammer();
    }

    private final OAuth oAuthFactory(String consumerKey, String consumerKeySecret) {
        try {
            return new OAuthImpl(consumerKey, consumerKeySecret);
        } catch (ClientProtocolException e) {
            throw new YammerException(e);
        } catch (IOException e) {
            throw new YammerException(e);
        }
    }

    private final OAuth oAuthFactory() {
        return new OAuthImpl();
    }

    private final Users usersFactory() {
        return new UsersImpl();
    }
    private final Messages messagesFactory() {
        return new MessagesImpl();
    }
}
