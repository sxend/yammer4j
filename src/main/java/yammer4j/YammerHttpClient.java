package yammer4j;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;


class YammerHttpClient {
    private static final String USER_AGENT;
    private final HttpClient httpClient;
    private AccessToken accessToken = null;

    static {
        USER_AGENT = "Yammer4j/HttpClient0.0.1";
    }

    private YammerHttpClient() {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, 80, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(schemeRegistry));
        HttpParams params = defaultHttpClient.getParams();
        HttpConnectionParams.setSoTimeout(params, 5000);
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setTcpNoDelay(params, true);
        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
        HttpProtocolParams.setHttpElementCharset(params, HTTP.UTF_8);
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpClientParams.setRedirecting(params, false);

        httpClient = defaultHttpClient;

    }

    static YammerHttpClient getInstance() {
        return new YammerHttpClient();
    }

    void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    private boolean tokenIsNull() {
        return this.accessToken == null || this.accessToken.getToken() == null;
    }


    YammerHttpResponse execute(ApiQuery query) {
        HttpUriRequest request = generateRequest(query);
        setHeader(request);

        try {
            HttpResponse httpResponse = this.httpClient.execute(request);
            return new YammerHttpResponse(httpResponse.getStatusLine().getStatusCode(),readEntityAsString(httpResponse.getEntity()));
        } catch (IOException e) {
            return new YammerHttpResponse(e);
        }
    }

    private String readEntityAsString(HttpEntity entity) throws IOException {
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
            int i = (int) entity.getContentLength();
            if (i < 0) {
                i = 4096;
            }
            if (entity.getContentEncoding() != null && entity.getContentEncoding().getValue().equals("gzip")) {
                instream = new GZIPInputStream(instream);
            }
            Reader reader = new InputStreamReader(instream, HTTP.UTF_8);
            CharArrayBuffer buffer = new CharArrayBuffer(i);
            char[] tmp = new char[1024];
            int l;
            while ((l = reader.read(tmp)) != -1) {
                buffer.append(tmp, 0, l);
            }
            return buffer.toString();
        } finally {
            instream.close();
        }
    }

    private void setHeader(HttpUriRequest request) {
        if (!tokenIsNull()) {
            request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken.getToken());
        }
        request.setHeader(HttpHeaders.USER_AGENT, USER_AGENT);
        request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip,deflate");
        request.setHeader(HttpHeaders.ACCEPT_CHARSET, "utf-8;q=0.7,*;q=0.3");
        request.setHeader(HttpHeaders.HOST, "www.yammer.com");
    }

    private HttpUriRequest generateRequest(ApiQuery query) {
        return new HttpGet(query.createRequestUrl());
    }

}
