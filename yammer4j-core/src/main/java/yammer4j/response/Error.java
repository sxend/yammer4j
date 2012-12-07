package yammer4j.response;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 23:22
 */
public interface Error {
    public String getType();
    public String getMessage();
    public final static class DefaultError implements Error{
        private final String type;
        private final String message;
        public DefaultError(String type ,String message){
            this.type = type;
            this.message = message;
        }

        public String getType() {
            return this.type;
        }

        public String getMessage() {
            return this.message;
        }
    }
}
