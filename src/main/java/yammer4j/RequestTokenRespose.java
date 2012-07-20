package yammer4j;

public class RequestTokenRespose {

	private final String oauthToken;
	private final String oauthTokenSecret;
	private final Boolean oauthCallbackConfirmed;

	RequestTokenRespose(String oauthToken, String oauthTokenSecret,
			Boolean oauthCallbackConfirmed) {
		this.oauthToken = oauthToken;
		this.oauthTokenSecret = oauthTokenSecret;
		this.oauthCallbackConfirmed = oauthCallbackConfirmed;
	}

	public String getOauthToken() {
		return oauthToken;
	}

	public String getOauthTokenSecret() {
		return oauthTokenSecret;
	}

	public Boolean getOauthCallbackConfirmed() {
		return oauthCallbackConfirmed;
	}

}
