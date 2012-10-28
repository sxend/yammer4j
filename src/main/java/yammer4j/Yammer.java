package yammer4j;

public final class Yammer {
	public final OAuth oauth2;
	private Yammer() {
		oauth2 = new OAuthImpl();
	}
	public static Yammer getYammer() {
		return new Yammer();
	}

}
