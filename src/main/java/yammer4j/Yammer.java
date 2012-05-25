package yammer4j;

import yammer4j.messages.Messages;
import yammer4j.messages.MessagesImpl;
import yammer4j.oauth.OAuth;
import yammer4j.oauth.OAuthImpl;

public final class Yammer {


	public static final String YAMMER_DOMAIN="www.yammer.com";
	public static final String YAMMER_API_AUFFIX="/api/v1";
	public static final String USING_HTTO_PROTOCOL="https://";
	public static final OAuth oauth = initOAuthApi();
	public static final Messages messages = initMessagesApi();

	private static OAuth initOAuthApi(){
		return new OAuthImpl();
	}

	private static Messages initMessagesApi() {
		return new MessagesImpl();
	}


}
