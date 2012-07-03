package yammer4j.exception;

public class YammerException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final String UNSUPPORTED_API_EXCEPTION = "そのAPIはサポートしてへんで！";

	public YammerException(Exception e) {
		super(e);
	}

}
