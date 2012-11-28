package yammer4j_old;

public interface OAuth {

	String getRedirectUrl(String clientId, String callBackUrl);

	AccessToken getToken(String clientId, String callBackUrl);

	AccessToken getToken(String clientId, String clientSecret, String code);

	UnAuthorisedToken getPreAuthorizedTokenForAdmin(String userId, String consumerKey);

	AccessToken getAuthorizedToken(String userId, String consumerKey);

}
