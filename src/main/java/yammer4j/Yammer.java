package yammer4j;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

public final class Yammer {

	public static final String YAMMER_URL = "https://www.yammer.com";
	public static final String YAMMER_API_BASE_URL = YAMMER_URL + "/api/v1";

	public final Authorize auth;

	private Yammer(String consumerKey, String consumerKeySecret) {
			this.auth = authFactory(consumerKey, consumerKeySecret);
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
