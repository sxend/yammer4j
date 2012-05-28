package yammer4j;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import yammer4j.exception.YammerException;

public final class Yammer {

	public static final String YAMMER_URL = "https://www.yammer.com";
	public static final String YAMMER_API_BASE_URL = YAMMER_URL + "/api/v1";

	public final Authorize auth;
	public final Users users;

	private Yammer(String consumerKey, String consumerKeySecret) {
			this.auth = authFactory(consumerKey, consumerKeySecret);
			this.users = usersFactory();
	}

	public static final Yammer getYammer(String consumerKey,
			String consumerKeySecret) throws ParseException, IOException {
		return new Yammer(consumerKey, consumerKeySecret);
	}

	private static final Authorize authFactory(String consumerKey,
			String consumerKeySecret) {
		try {
			return new AuthorizeImpl(consumerKey, consumerKeySecret);
		} catch (ClientProtocolException e) {
			throw new YammerException(e);
		} catch (IOException e) {
			throw new YammerException(e);
		}
	}
	private Users usersFactory() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
