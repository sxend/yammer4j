package yammer4j;

import org.apache.http.*;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;

/**
 * User: sxend
 * Date: 12/12/03
 * Time: 22:26
 */
class YammerHttpResponse {
    private final int statusCode;
    private final String entityString;
    private final Exception exception;

    YammerHttpResponse(int statusCode ,String entityString){
        this.statusCode = statusCode;
        this.entityString = entityString;
        this.exception = null;
    }
    YammerHttpResponse(Exception exception){
        this.statusCode = -1;
        this.entityString = exception.getMessage();
        this.exception = exception;
    }

    int getStatusCode() {
        return this.statusCode;
    }
    String getEntityString() {
        return this.entityString;
    }
    Exception getException(){
        return this.exception;
    }


}
