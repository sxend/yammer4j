package yammer4j_old.exception;


public class BadRequestException extends YammerException{

	public BadRequestException(String reasonPhrase) {
		super(reasonPhrase);
	}

	private static final long serialVersionUID = 7826406140771426683L;

}
