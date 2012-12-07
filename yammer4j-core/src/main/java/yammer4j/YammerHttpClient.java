package yammer4j;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
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
import yammer4j.exception.YammerException;
import yammer4j.response.AccessToken;

import java.io.IOException;


class YammerHttpClient {
    private static final String USER_AGENT;
    private final HttpClient httpClient;
    private AccessToken accessToken = null;
    private ResponseType responseType = ResponseType.JSON;

    static {
        USER_AGENT = "Yammer4j/HttpClient0.0.1";
    }

    private YammerHttpClient() {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, 80, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(schemeRegistry));
        HttpParams params = defaultHttpClient.getParams();
        HttpConnectionParams.setSoTimeout(params, 3000);
        HttpConnectionParams.setConnectionTimeout(params, 3000);
        HttpConnectionParams.setTcpNoDelay(params, true);
        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
        HttpProtocolParams.setHttpElementCharset(params, HTTP.UTF_8);
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpClientParams.setRedirecting(params, false);

        httpClient = (HttpClient) defaultHttpClient;

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

    void setResponseType(ResponseType responseType) {
        this.responseType = responseType == null ? ResponseType.JSON : responseType;
    }

    YammerHttpResponse execute(ApiQuery query) throws YammerException {
        HttpUriRequest request = generateRequest(query, responseType);
        setHeader(request);

        HttpResponse response = null;
        try {
            response = this.httpClient.execute(request);
        } catch (IOException e) {
            throw new YammerException(e);
        }
        return createYammerApiResponse(response);
    }

    private YammerHttpResponse createYammerApiResponse(HttpResponse response) throws YammerException {
           return new YammerHttpResponse(response);
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

    private HttpUriRequest generateRequest(ApiQuery query, ResponseType responseType) {
        return new HttpGet(query.createRequestUrl(responseType));
    }


}
