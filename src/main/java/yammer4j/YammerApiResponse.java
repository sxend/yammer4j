package yammer4j;

import org.apache.http.*;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Locale;

/**
 * User: sxend
 * Date: 12/12/03
 * Time: 22:26
 */
class YammerApiResponse {
    private final HttpResponse httpResponse;
    private final String entityString;

    YammerApiResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
        try {
            this.entityString = EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);//TODO gzip圧縮比対応
        } catch (IOException e) {
            throw new YammerException(e.getMessage());
        }
    }

    StatusLine getStatusLine() {
        return httpResponse.getStatusLine();
    }

    HeaderIterator headerIterator() {
        return httpResponse.headerIterator();
    }

    Header[] getHeaders(String name) {
        return httpResponse.getHeaders(name);
    }

    ProtocolVersion getProtocolVersion() {
        return httpResponse.getProtocolVersion();
    }

    HeaderIterator headerIterator(String name) {
        return httpResponse.headerIterator(name);
    }

    Header getFirstHeader(String name) {
        return httpResponse.getFirstHeader(name);
    }

    HttpParams getParams() {
        return httpResponse.getParams();
    }

    String getEntityString() {
        return this.entityString;
    }

    boolean containsHeader(String name) {
        return httpResponse.containsHeader(name);
    }

    Locale getLocale() {
        return httpResponse.getLocale();
    }

    Header getLastHeader(String name) {
        return httpResponse.getLastHeader(name);
    }

    Header[] getAllHeaders() {
        return httpResponse.getAllHeaders();
    }

    private boolean isGZipHttpResponse(HttpResponse httpResponse) {
        Header header = httpResponse.getEntity().getContentEncoding();
        if (header == null) {
            return false;
        }
        return header.getValue() != null && header.getValue().equals("gzip");
    }


}
