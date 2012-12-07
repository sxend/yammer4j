package yammer4j;

import org.apache.http.*;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import yammer4j.exception.YammerException;
import yammer4j.response.*;
import yammer4j.response.Error;
import yammer4j.util.RegexUtil;

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
public class YammerHttpResponse {
    private final int statusCode;
    private final String entityString;


    YammerHttpResponse(HttpResponse httpResponse) throws YammerException {
        this.statusCode = httpResponse.getStatusLine().getStatusCode();
        try {
//            this.entityString = EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
            this.entityString = readEntityAsString(httpResponse.getEntity());
        } catch (IOException e) {
            throw new YammerException(e);
        }

    }
    private String readEntityAsString(HttpEntity entity)throws IOException{
        if (entity == null) {
            throw new IOException("HTTP entity may not be null");
        }
        InputStream instream = entity.getContent();
        if (instream == null) {
            return null;
        }
        try {
            if (entity.getContentLength() > Integer.MAX_VALUE) {
                throw new IOException("HTTP entity too large");
            }
            int i = (int)entity.getContentLength();
            if (i < 0) {
                i = 4096;
            }
            if(entity.getContentEncoding() != null && entity.getContentEncoding().getValue().equals("gzip")){
                 instream = new GZIPInputStream(instream);
            }
            Reader reader = new InputStreamReader(instream, HTTP.UTF_8);
            CharArrayBuffer buffer = new CharArrayBuffer(i);
            char[] tmp = new char[1024];
            int l;
            while((l = reader.read(tmp)) != -1) {
                buffer.append(tmp, 0, l);
            }
            return buffer.toString();
        } finally {
            instream.close();
        }
    }

    public int getStatusCode() {
        return this.statusCode;
    }
    public String getEntityString() {
        return this.entityString;
    }

}
