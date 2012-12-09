package yammer4j;

public final class AccessToken implements Success {
    public AccessToken(String token) {
        this.token = token == null ? "" : token;
    }

    private final String token;

    public String getToken() {
        return this.token;
    }

    @Override
    public int hashCode() {
        return 31 + (token == null ? 0 : token.hashCode());
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof AccessToken){
            return token.equals(o.toString());
        }
        return false;
    }
    @Override
    public String toString() {
        return this.token;
    }
}
