package yammer4j;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

final class YammerHttpClient {

	private final HttpClient httpClient;
	private static final String[] strArray = new String[] {};

	static YammerHttpClient getClient() {
		return new YammerHttpClient();
	}

	private YammerHttpClient() {
		httpClient = new DefaultHttpClient();
	}

	public void get(String url, Map<String, String> httpParams) {
		get(url, httpParams, null);
	}

	public void post(String url, Map<String, String> httpParams) {
		post(url, httpParams, null);
	}

	public void get(String url, Map<String, String> httpParams, String token) {
		HttpUriRequest request = new HttpGet(url);
		execute(request, createRequestParam(httpParams), token);
	}

	public void post(String url, Map<String, String> httpParams, String token) {
		HttpUriRequest request = new HttpPost(url);
		execute(request, createRequestParam(httpParams), token);
	}

	private void execute(HttpUriRequest request, HttpParams httpParams,
			String token) {
		request.setParams(httpParams);
		if (token != null) {
			request.addHeader("Authorization", "Bearer " + token);
		}

		HttpResponse httpResponse = null;
		try {
			synchronized (httpClient) {

				httpResponse = httpClient.execute(request);
				// ココでレスポンスのオブジェクト作成
				if (httpResponse != null
						&& httpResponse.getEntity().isStreaming()) {
					httpResponse.getEntity().getContent().close();
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private HttpParams createRequestParam(Map<String, String> paramMap) {
		HttpParams httpParams = new BasicHttpParams();
		String[] keyArray = paramMap.keySet().toArray(strArray);
		for (String key : keyArray) {
			httpParams.setParameter(key, paramMap.get(key));
		}
		return httpParams;
	}

}
