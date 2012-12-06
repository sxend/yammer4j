package yammer4j;


import org.apache.http.HttpResponse;

public class YammerException extends Exception implements YammerResponse<Void> {
    private final Exception exception;
    private final HttpResponse httpResponse;

    YammerException(HttpResponse httpResponse, Exception exception) {
        this.exception = exception;
        this.httpResponse = httpResponse;
    }

    YammerException(HttpResponse httpResponse) {
        this.exception = new Exception(httpResponse.getStatusLine().getReasonPhrase());
        this.httpResponse = httpResponse;
    }

    YammerException(Exception exception) {
        this.exception = exception;
        this.httpResponse = null;
    }

    public int getStatusCode() {
        return httpResponse != null ? httpResponse.getStatusLine().getStatusCode() : 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Void getSucceedResponse() {
        return null;
    }

    public boolean isErrorResponse() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getErrorMessage() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
