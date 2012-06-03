package yammer4j.obj;

public class TokenPair {

    private String token;
    private String tokenSecret;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

}
