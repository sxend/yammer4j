package yammer4j.test;

import org.junit.Assert;
import org.junit.Test;

import yammer4j.Messages.MessagesResponse;
import yammer4j.Yammer;


public class MessagesTest {

	@Test
	public void getMessagesTest (){
		Yammer yammer = Yammer.getYammer(TestUtil.getAuthorizedKeySet());

		MessagesResponse messagesResponse = yammer.messages.getMessages();
		Assert.assertEquals(Integer.valueOf(200), messagesResponse.getStatusCode());
	}

	@Test
	public void getMessagesSentTest(){
		Yammer yammer = Yammer.getYammer(TestUtil.getAuthorizedKeySet());

		MessagesResponse messagesResponse = yammer.messages.getMessagesSent();
		Assert.assertEquals(Integer.valueOf(200), messagesResponse.getStatusCode());
	}


}
