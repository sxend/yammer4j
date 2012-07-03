package yammer4j;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import yammer4j.obj.ConsumerKeyPair;
import yammer4j.obj.UnAuthorizedKeySet;

public class YammerTest {
	private static final boolean FLAG = true;

	@Test
	public void yammerTest() {
		JUnitResultUtil.timeStamp();
		List<Object> resultObjects = new ArrayList<Object>();

		Yammer yammer = Yammer.getYammer();
		ConsumerKeyPair consumerKeyPair = new ConsumerKeyPair(
				HiddenPropertiesUtil.getString("consumerKey"),
				HiddenPropertiesUtil.getString("consumerKeySecret"));

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

		Assert.assertEquals(HiddenPropertiesUtil.getString("consumerKey"),
				unAuthorizedKeySet.getConsumerKeyPair().getConsumerKey());
		Assert.assertEquals(HiddenPropertiesUtil.getString("consumerKeySecret"),
				unAuthorizedKeySet.getConsumerKeyPair().getConsumerKeySecret());

		JUnitResultUtil.toString(FLAG, resultObjects.toArray());
		JUnitResultUtil.timeStamp();
	}

}
