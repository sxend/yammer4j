package yammer4j;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 21:35
 */
public interface YammerResponse<T> {
    public int getStatusCode();

    public T getSucceedResponse();

    public boolean isErrorResponse();

    public String getErrorMessage();
}
