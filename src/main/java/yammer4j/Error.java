package yammer4j;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 23:22
 */
public class Error {

    private final String type;
    private final String message;

    Error(Exception e) {
        this.type = e.toString();
        this.message = e.getMessage();
    }

    Error(String type, String message) {
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
