package yammer4j;

import org.apache.http.HttpStatus;

import java.lang.*;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 21:57
 */
public class YammerResponse<S extends Success> implements Response {
    private final S success;
    private final Error error;
    private final int statusCode;

    YammerResponse(final ResponseFactory<S> factory){
        final YammerHttpResponse response = factory.getResponse();
        this.statusCode = response.getStatusCode();
        final String entityString = new String(response.getEntityString());

        if(statusCode == HttpStatus.SC_OK){
            this.success = factory.onSuccess();
            this.error = null;
        }else if(statusCode == HttpStatus.SC_BAD_REQUEST){
            this.success = null;
            this.error = factory.onBadRequest();
        }else if(statusCode == HttpStatus.SC_UNAUTHORIZED){
            this.success = null;
            this.error = factory.onUnAuthorized();
        }else if( statusCode >= HttpStatus.SC_CONTINUE){
            this.success = null;
            this.error = new Error("StatusCode : " + this.statusCode, entityString);
        }else{
            this.success = null;
            this.error = new Error(response.getException());
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
