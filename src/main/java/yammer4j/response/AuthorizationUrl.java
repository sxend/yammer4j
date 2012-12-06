package yammer4j.response;


/**
 * User: sxend
 * Date: 12/12/07
 * Time: 0:02
 */
public class AuthorizationUrl implements Success {
    private final String authorizationUrl;
    public AuthorizationUrl(String authorizationUrl){
         this.authorizationUrl = authorizationUrl;
    }
    public String getAuthorizationUrl(){
        return this.authorizationUrl;
    }
}
