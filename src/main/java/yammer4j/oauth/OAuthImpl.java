package yammer4j.oauth;

import yammer4j.exception.YammerException;

public final class OAuthImpl implements OAuth {

	public Boolean isAuthorized() throws YammerException {
		throw new YammerException(YammerException.UNSUPPORTED_API_EXCEPTION);
	}

}
