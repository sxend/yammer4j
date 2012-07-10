package yammer4j.test;

import java.util.Date;

import org.junit.Ignore;

import yammer4j.obj.AuthorizedKeySet;
import yammer4j.obj.ConsumerKeyPair;
import yammer4j.obj.TokenPair;

@Ignore
public class TestUtil {

	public static void timeStamp() {
		System.out.println(new Date(System.currentTimeMillis()).toString());

	}

	private static void toString(boolean flag, Object object) {
		if (flag) {
			System.out.println(object.toString());
		}
	}

	public static void toString(boolean flag, Object... objects) {
		for (Object object : objects) {
			toString(flag, object);
		}
	}

	public static AuthorizedKeySet getAuthorizedKeySet() {
		AuthorizedKeySet authorizedKeySet = new AuthorizedKeySet();
		ConsumerKeyPair consumerKeyPair = new ConsumerKeyPair(
				HiddenProperties.getString("consumerKey"),
				HiddenProperties.getString("consumerKeySecret"));
		TokenPair tokenPair = new TokenPair(
				HiddenProperties.getString("token"),
				HiddenProperties.getString("tokenSecret"));
		authorizedKeySet.setConsumerKeyPair(consumerKeyPair);
		authorizedKeySet.setTokenPair(tokenPair);
		authorizedKeySet.setoAuthVerifier(HiddenProperties
				.getString("oAuthVerifier"));
		return authorizedKeySet;
	}

}
