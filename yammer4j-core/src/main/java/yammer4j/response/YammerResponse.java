package yammer4j.response;

import org.apache.http.HttpStatus;
import yammer4j.ResponseFactory;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 21:57
 */
public class YammerResponse<S extends Success> implements Response<S, Error> {
    private final S success;
    private final Error error;
    private final int statusCode;

    public YammerResponse(final ResponseFactory<S> factory){
        this.statusCode = factory.getResponse().getStatusCode();
        final String entityString = new String(factory.getResponse().getEntityString());

        if(statusCode == HttpStatus.SC_OK){
            this.success = factory.onSuccess();
            this.error = null;
        }else if(statusCode == HttpStatus.SC_BAD_REQUEST){
            this.success = null;
            this.error = factory.onBadRequest();
        }else{
            this.success = null;
            this.error = new Error.DefaultError("StatusCode : " + this.statusCode, entityString);
        }
    }

    public int getStatusCode() {
        return this.statusCode;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isSuccess() {
        return this.success != null;
    }

    public S getSuccess() {
        return this.success;
    }

    public Error getError() {
        return this.error;
    }


}
