package yammer4j;

import yammer4j.obj.AuthorizedKeySet;

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
		this.client = yammerHttpClientFactory();
		this.oAuth = oAuthFactory();
		this.users = usersFactory();
		this.messages = messagesFactory();
		this.groups = groupsFactory();
		this.likes = likesFactory();
	}

	public static final Yammer getYammer() {
		return new Yammer();
	}

	public static final Yammer getYammer(AuthorizedKeySet authorizedKeySet) {
		return new Yammer().setAuthorizedKeySet(authorizedKeySet);
	}

	private YammerHttpClient yammerHttpClientFactory() {
		return new YammerHttpClient();
	}

	public Yammer setAuthorizedKeySet(AuthorizedKeySet authorizedKeySet) {
		this.client.setAuthorizeElements(authorizedKeySet);
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
