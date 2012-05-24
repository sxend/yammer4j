package yammer4j.oauth;

public final class OAuthFactory {

	public static final OAuth init() {
		return new OAuthImpl();
	}
}
