package yammer4j.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import yammer4j.Messages.MessagesResponse;
import yammer4j.Yammer;


public class MessagesTest {


	@Test
	public void messagesTest () throws IOException{
		Yammer yammer = Yammer.getYammer(TestUtil.getAuthorizedKeySet());

		//続行
		MessagesResponse messagesResponse;
		messagesResponse= yammer.messages.getMessagesSent();
		Assert.assertEquals(Integer.valueOf(200), messagesResponse.getStatusCode());

		messagesResponse = yammer.messages.getMessages();
		Assert.assertEquals(Integer.valueOf(200), messagesResponse.getStatusCode());


	}
}
