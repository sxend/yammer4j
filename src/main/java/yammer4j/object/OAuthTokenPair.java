package yammer4j.object;

public final class OAuthTokenPair {

	private final String oAuthToken;
	private final String oAuthTokenSecret;

	public OAuthTokenPair(String oAuthToken, String oAuthTokenSecret) {
		this.oAuthToken = oAuthToken;
		this.oAuthTokenSecret = oAuthTokenSecret;
	}

	public String getOAuthToken() {
		return oAuthToken;
	}

	public String getOAuthTokenSecret() {
		return oAuthTokenSecret;
	}


}
