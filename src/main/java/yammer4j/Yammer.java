package yammer4j;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import yammer4j.exception.YammerException;

public final class Yammer {



	public final OAuth auth;
	public final Users users;

	private Yammer() {
			this.auth = oauthFactory();
			this.users = usersFactory();
	}



	public static final Yammer getYammer(){
		return new Yammer();
	}

	private static final OAuth oauthFactory() {
			return new OAuthImpl();

	}
	private Users usersFactory() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
