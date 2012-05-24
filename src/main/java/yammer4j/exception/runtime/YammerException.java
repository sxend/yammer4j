package yammer4j.exception.runtime;

public class YammerException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final String UNSUPPORTED_API_EXCEPTION = "そのAPIはサポートしてへんで！";

	public YammerException(String messages) {
		super(messages);
	}

}
