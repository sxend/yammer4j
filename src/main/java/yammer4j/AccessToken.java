package yammer4j;

public final class AccessToken {
    public AccessToken(String token) {
        this.token = token;
    }

    private final String token;

    public String getToken() {
        return this.token;
    }
}
