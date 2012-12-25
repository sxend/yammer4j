package yammer4j;

public final class Json implements Success {
    public Json(String json) {
        this.json = json == null ? "" : json;
    }

    private final String json;

    public String getJson() {
        return this.json;
    }

    @Override
    public int hashCode() {
        return 31 + (json == null ? 0 : json.hashCode());
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Json){
            return json.equals(o.toString());
        }
        return false;
    }
    @Override
    public String toString() {
        return this.json;
    }
    static JsonResponseFactory getJsonResponseFactory(YammerHttpResponse response){
        return new JsonResponseFactory(response);
    }
    static final class JsonResponseFactory extends ResponseFactory<Json> {

        JsonResponseFactory( YammerHttpResponse response){
            super(response);
        }
        @Override
        Json onSuccess() {
            return new Json(this.response.getEntityString());
        }
    }
}
