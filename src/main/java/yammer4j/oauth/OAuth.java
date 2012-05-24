package yammer4j.oauth;

import yammer4j.exception.YammerException;

public interface OAuth {
	public Boolean isAuthorized() throws YammerException;

}
