package yammer4j;

import org.apache.http.HttpResponse;




public interface Messages {
	public static final String Messages = "/messages.json";
	public static final String MessagesSent = "/messages/sent.json";

	public MessagesResponse getMessages();

	public MessagesResponse getMessagesSent();


	public class MessagesResponse extends YammerResponse{
		public MessagesResponse(HttpResponse httpResponse) {
			super(httpResponse);
		}
	}
}
