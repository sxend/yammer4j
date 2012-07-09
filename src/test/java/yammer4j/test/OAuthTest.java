package yammer4j.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import yammer4j.Yammer;
import yammer4j.obj.AuthorizedKeySet;
import yammer4j.obj.ConsumerKeyPair;
import yammer4j.obj.UnAuthorizedKeySet;

public class OAuthTest {

	@Test
	public void oAuthTest() throws IOException {
		TestUtil.timeStamp();
		List<Object> resultObjects = new ArrayList<Object>();

		Yammer yammer = Yammer.getYammer();
		ConsumerKeyPair consumerKeyPair = new ConsumerKeyPair(
				HiddenProperties.getString("oAuthTest-consumerKey"),
				HiddenProperties.getString("oAuthTest-consumerKeySecret"));

		UnAuthorizedKeySet unAuthorizedKeySet = yammer.oAuth
				.requestToken(consumerKeyPair);

		Assert.assertNotNull(unAuthorizedKeySet);
		resultObjects.add(unAuthorizedKeySet);

		Assert.assertNotNull(unAuthorizedKeySet.getConsumerKeyPair());
		resultObjects.add(unAuthorizedKeySet.getConsumerKeyPair());

		Assert.assertNotNull(unAuthorizedKeySet.getConsumerKeyPair()
				.getConsumerKey());
		resultObjects.add(unAuthorizedKeySet.getConsumerKeyPair()
				.getConsumerKey());

		Assert.assertNotNull(unAuthorizedKeySet.getConsumerKeyPair()
				.getConsumerKeySecret());
		resultObjects.add(unAuthorizedKeySet.getConsumerKeyPair()
				.getConsumerKeySecret());

		Assert.assertNotNull(unAuthorizedKeySet.getTokenPair());
		resultObjects.add(unAuthorizedKeySet.getTokenPair());

		Assert.assertNotNull(unAuthorizedKeySet.getTokenPair().getToken());
		resultObjects.add(unAuthorizedKeySet.getTokenPair().getToken());

		Assert.assertNotNull(unAuthorizedKeySet.getTokenPair().getTokenSecret());
		resultObjects.add(unAuthorizedKeySet.getTokenPair().getTokenSecret());

		Assert.assertEquals(HiddenProperties.getString("oAuthTest-consumerKey"),
				unAuthorizedKeySet.getConsumerKeyPair().getConsumerKey());
		Assert.assertEquals(HiddenProperties.getString("oAuthTest-consumerKeySecret"),
				unAuthorizedKeySet.getConsumerKeyPair().getConsumerKeySecret());

		System.out.println(yammer.oAuth.getAuthorizedUrl(unAuthorizedKeySet));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String oAuthVerifier = br.readLine();

		AuthorizedKeySet authorizedKeySet = yammer.oAuth.accessToken(oAuthVerifier, unAuthorizedKeySet);

		TestUtil.timeStamp();
	}
}
