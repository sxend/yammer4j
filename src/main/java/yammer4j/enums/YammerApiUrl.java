package yammer4j.enums;

public enum YammerApiUrl {

	requestTokenUrl("/oauth/request_token"),
	accessTokenUrl("/oauth/access_token");

	private String url;

	YammerApiUrl(String url) {
		this.url = url;
	}

	public String getUrl(){
		return this.url;
	}
}
