package yammer4j;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 21:35
 */
public interface Response<Success,Error> {
    public int getStatusCode();
    public boolean isSuccess();
    public Success getSuccess();
    public Error getError();

}
