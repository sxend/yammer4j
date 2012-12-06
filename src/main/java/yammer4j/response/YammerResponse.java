package yammer4j.response;

import yammer4j.response.Error;
import yammer4j.response.Response;
import yammer4j.response.Success;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 21:57
 */
public class YammerResponse<S extends Success> implements Response<S, Error> {
    private final S success;
    private final Error error;
    public YammerResponse(S success,Error error){
        this.success = success;
        this.error = error;
    }

    public YammerResponse(S success) {
        this.success = success;
        this.error = Error.NullError;
    }
//    public int getStatusCode() {
//        return 0;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public T getSuccess() {
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public Error getError() {
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public boolean isSuccess() {
//        return false;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public boolean hasError() {
//        return false;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public T getSucceedResponse() {
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public boolean isErrorResponse() {
//        return false;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public String getErrorMessage() {
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
//    }
}
