package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/28
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
public final class AccessToken {
    public AccessToken(String token){
        this.token = token;
    }
    private final String token;
    public String getToken(){
        return this.token;
    }
}
