package yammer4j_old.exception;


public class UnAuthorizedException extends YammerException{

	public UnAuthorizedException(String reasonPhrase) {
		super(reasonPhrase);
	}

	private static final long serialVersionUID = 6744352373423713787L;

}