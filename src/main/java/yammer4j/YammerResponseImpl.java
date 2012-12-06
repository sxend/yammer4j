package yammer4j;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 21:57
 */
public class YammerResponseImpl<T> implements YammerResponse<T> {
    public int getStatusCode() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public T getSucceedResponse() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isErrorResponse() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getErrorMessage() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
