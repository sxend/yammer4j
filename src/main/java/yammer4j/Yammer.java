package yammer4j;


public final class Yammer {

	public static final String USING_HTTP_PROTOCOL = "https://";
	public static final String YAMMER_DOMAIN = "www.yammer.com";
	public static final String YAMMER_BASE_URL = new StringBuilder(
			USING_HTTP_PROTOCOL).append(YAMMER_DOMAIN).toString();
	public static final String YAMMER_API_SUFFIX = "/api/v1";
	public static final String YAMMER_API_BASE_URL = new StringBuilder(
			YAMMER_BASE_URL).append(YAMMER_API_SUFFIX).toString();

	public static final OAuthApi oauth = initOAuthApi();

	private static OAuthApi initOAuthApi() {
		return new OAuthApiImpl();
	}
}
