package yammer4j;

import yammer4j.messages.Messages;
import yammer4j.messages.MessagesFactory;
import yammer4j.oauth.OAuth;
import yammer4j.oauth.OAuthFactory;

public final class Yammer {

	public static final OAuth oauth = OAuthFactory.init();
	public static final Messages messages = MessagesFactory.init();

}
