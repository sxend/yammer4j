package yammer4j.obj;

public class ConsumerKeyPair {

	private String consumerKey;
	private String consumerKeySecret;

	public ConsumerKeyPair() {

	}

	public ConsumerKeyPair(String consumerKey, String consumerKeySecret) {
		this.consumerKey = consumerKey;
		this.consumerKeySecret = consumerKeySecret;
	}

	public void setConsumerKeySecret(String consumerKeySecret) {
		this.consumerKeySecret = consumerKeySecret;
	}

	public String getConsumerKeySecret() {
		return consumerKeySecret;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

}
