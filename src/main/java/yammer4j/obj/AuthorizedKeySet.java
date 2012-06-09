package yammer4j.obj;

public class AuthorizedKeySet {

    private ConsumerKeyPair consumerKeyPair;
    private TokenPair tokenPair;
    private String oAuthVerifier;

    public void setConsumerKeyPair(ConsumerKeyPair consumerKeyPair) {
        this.consumerKeyPair = consumerKeyPair;
    }

    public ConsumerKeyPair getConsumerKeyPair() {
        return consumerKeyPair;
    }



    public void setoAuthVerifier(String oAuthVerifier) {
        this.oAuthVerifier = oAuthVerifier;
    }

    public String getoAuthVerifier() {
        return oAuthVerifier;
    }

    public void setTokenPair(TokenPair tokenPair) {
        this.tokenPair = tokenPair;
    }

    public TokenPair getTokenPair() {
        return tokenPair;
    }

}
