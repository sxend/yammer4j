package testapp;

import yammer4j.AccessToken;
import yammer4j.UnAuthorisedToken;
import yammer4j.Yammer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Yammer yammer = Yammer.getYammer();
		Thread thread1 = new Thread(new runner(yammer));
		thread1.start();
		Thread thread2 = new Thread(new runner(yammer));
		thread2.start();
		Thread thread3 = new Thread(new runner(Yammer.getYammer()));
		thread3.start();
	}
	static class runner implements Runnable{
		private Yammer yammer;

		public runner(Yammer yammer) {
			this.yammer = yammer;
		}

		public void run() {
			String clientId = "";
			String callBackUrl = "";
			String clientSecret = "";
			String code = "";
			String consumerKey = "";
			String userId = "";
			String redirectUrl = yammer.oauth2.getRedirectUrl(clientId,callBackUrl);
			AccessToken token = yammer.oauth2.getToken(clientId,callBackUrl);
			AccessToken token2= yammer.oauth2.getToken(clientId,clientSecret,code);
			UnAuthorisedToken token3 =yammer.oauth2.getPreAuthorizedTokenForAdmin(userId,consumerKey);
			AccessToken untoken = yammer.oauth2.getAuthorizedToken(userId,consumerKey);

		}

	}

}
