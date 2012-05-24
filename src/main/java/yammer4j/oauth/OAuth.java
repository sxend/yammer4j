package yammer4j.oauth;

import yammer4j.exception.runtime.YammerException;

public interface OAuth {
	public Boolean isAuthorized() throws YammerException;

}
