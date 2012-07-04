package yammer4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

final class MessagesImpl extends AbstractYammerApi implements Messages {

	protected MessagesImpl(YammerHttpClient client) {
		super(client);
	}

	public HttpResponse getMessages() {
		HttpGet httpGet = new HttpGet(BASE_API_URL + Messages);
		return client.request(httpGet);
	}

	public HttpResponse getMessagesSent() {
		HttpGet httpGet = new HttpGet(BASE_API_URL + MessagesSent);
		return client.request(httpGet);
	}

}
