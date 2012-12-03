package yammer4j;

import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
class YammerHttpClient {
    private static final String USER_AGENT;
    private final HttpClient httpClient;
    private AccessToken accessToken = null;
    private ResponseType responseType = ResponseType.JSON;

    static {
        USER_AGENT = "Yammer4j/HttpClient0.0.1";
    }

    private YammerHttpClient() {
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setSoTimeout(params, 3000);
        HttpConnectionParams.setConnectionTimeout(params, 3000);
        HttpConnectionParams.setTcpNoDelay(params, true);
        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
        HttpProtocolParams.setHttpElementCharset(params, HTTP.UTF_8);
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(params, USER_AGENT);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, 80, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
        httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(schemeRegistry), params);
    }

    static YammerHttpClient getInstance() {
        return new YammerHttpClient();
    }

    void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    void get(String url, Boolean authFlg) {
    }

    void post() {
    }

    void delete() {
    }

    void put() {
    }

}
