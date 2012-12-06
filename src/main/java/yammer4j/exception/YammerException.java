package yammer4j.exception;


import org.apache.http.HttpResponse;
import yammer4j.response.Response;
import yammer4j.response.Success;

public class YammerException extends Exception implements Response<Success.NullSuccess,Error> {
    private final String message;
    public YammerException(Exception e) {
        this.message = e.getMessage();
    }
    public YammerException(String message){
        this.message = message;
    }
}
