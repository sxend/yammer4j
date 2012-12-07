package yammer4j.exception;


import org.apache.http.HttpResponse;
import yammer4j.response.*;
import yammer4j.response.Error;

public class YammerException extends Exception{
    private final Error error;
    public YammerException(Exception e) {
        this.error = new Error.DefaultError(e.getClass().getName(),e.getMessage());
    }

    public Error getError() {
        return this.error;
    }
}
