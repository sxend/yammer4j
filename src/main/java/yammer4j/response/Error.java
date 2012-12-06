package yammer4j.response;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 23:22
 */
public interface Error {
    static final  Error NullError = new NullError();
    public String getType();
    public String getMessage();
    public final static class NullError implements Error{
        public String getType() {
            return "";
        }
        public String getMessage() {
            return "";
        }
    }
}
