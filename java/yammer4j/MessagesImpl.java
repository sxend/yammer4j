package yammer4j;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

final class MessagesImpl extends AbstractYammerApi implements Messages {

	protected MessagesImpl(YammerHttpClient client) {
		super(client);
	}

	public MessagesResponse getMessages() {
		HttpGet httpGet = new HttpGet(BASE_API_URL + Messages);
		HttpResponse httpResponse = client.request(httpGet);

		return parsingObject(httpResponse);
	}

	public MessagesResponse getMessagesSent() {
		HttpGet httpGet = new HttpGet(BASE_API_URL + MessagesSent);
		HttpResponse httpResponse =  client.request(httpGet);
		return parsingObject(httpResponse);
	}


	@Override
	protected MessagesResponse parsingObject(HttpResponse httpResponse) {
		MessagesResponse messagesResponse = new MessagesResponse(httpResponse);

		return messagesResponse;
	}


}
