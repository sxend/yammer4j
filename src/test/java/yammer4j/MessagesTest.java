package yammer4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import yammer4j.obj.AuthorizedKeySet;

public class MessagesTest {

	private AuthorizedKeySet authorizedKeySet = null;

	@Test
	public void messagesTest () throws IOException{
		Yammer yammer = Yammer.getYammer(YammerTest.authorizedKeySet);

		//続行
		HttpResponse httpResponse;
		httpResponse= yammer.messages.getMessagesSent();
		Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		EntityUtils.consume(httpResponse.getEntity());

		httpResponse = yammer.messages.getMessages();
		Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		EntityUtils.consume(httpResponse.getEntity());


	}
}
