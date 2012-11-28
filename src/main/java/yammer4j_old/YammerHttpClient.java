package yammer4j_old;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
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
import org.apache.http.util.EntityUtils;

import yammer4j_old.exception.BadRequestException;
import yammer4j_old.exception.UnAuthorizedException;

final class YammerHttpClient {

	private static final String[] STR_ARRAY;
	private static final String USER_AGENT;
	private static final YammerHttpClient DEFAULT_CLIENT;
	private final HttpClient httpClient;

	static {
		STR_ARRAY = new String[] {};
		USER_AGENT = "Yammer4j/HttpClient0.0.1";
		DEFAULT_CLIENT = new YammerHttpClient();

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

		SchemeRegistry schreg = new SchemeRegistry();
		schreg.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, 80,
				PlainSocketFactory.getSocketFactory()));
		schreg.register(new Scheme("https", 443, SSLSocketFactory
				.getSocketFactory()));
		httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(
				schreg), params);

	}

	static YammerHttpClient getNewInstance() {
		return new YammerHttpClient();
	}

	static YammerHttpClient getInstance() {
		return DEFAULT_CLIENT;
	}

	public void get(String apiUrl, Map<String, String> queryParams) {
		get(apiUrl, queryParams, null);
	}

	public void post(String apiUrl, Map<String, String> queryParams) {
		post(apiUrl, queryParams, null);
	}

	public void get(String apiUrl, Map<String, String> queryParams, String token) {
		HttpUriRequest request = new HttpGet(createRequestUrl(apiUrl,
				queryParams));
		execute(request, queryParams, token);
	}

	public void post(String apiUrl, Map<String, String> queryParams,
			String token) {
		HttpUriRequest request = new HttpPost(createRequestUrl(apiUrl,
				queryParams));
		execute(request, queryParams, token);
	}

	private void execute(HttpUriRequest request,
			Map<String, String> queryParams, String token) {

		if (token != null) {
			request.addHeader("Authorization", "Bearer " + token);
		}

		try {
			HttpResponse httpResponse = httpClient.execute(request);
			EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
			validateStatusCode(httpResponse);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void validateStatusCode(HttpResponse httpResponse){
		switch (httpResponse.getStatusLine().getStatusCode()) {
		case HttpStatus.SC_BAD_REQUEST:
			throw new BadRequestException(httpResponse.getStatusLine().getReasonPhrase());
		case HttpStatus.SC_UNAUTHORIZED :
			throw new UnAuthorizedException(httpResponse.getStatusLine().getReasonPhrase());
		default:
			break;
		}
	}

	private String createRequestUrl(String apiUrl,
			Map<String, String> queryParams) {

		StringBuilder sb = new StringBuilder(apiUrl).append("?");
		String[] keyArray = queryParams.keySet().toArray(STR_ARRAY);
		for (String key : keyArray) {
			sb.append(key).append("=").append(queryParams.get(key)).append("&");
		}
		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

}
