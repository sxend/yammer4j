package yammer4j.exception;

import org.apache.http.HttpResponse;

public class YammerException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer statusCode;

	public YammerException(Exception e) {
		super(e);
	}

	public YammerException(Exception e, HttpResponse httpResponse) {
		this.statusCode = httpResponse.getStatusLine().getStatusCode();
	}


	public Integer getStatusCode(){
		return this.statusCode;
	}

}
