package yammer4j;


import yammer4j.Error;

public class YammerException extends Exception{
    private final Error error;
    YammerException(Exception e) {
        this.error = new Error.DefaultError(e.getClass().getName(),e.getMessage());
    }

    public Error getError() {
        return this.error;
    }
}
