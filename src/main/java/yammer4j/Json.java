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
}
