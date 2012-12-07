package yammer4j;

/**
 * User: sxend
 * Date: 12/12/07
 * Time: 11:59
 */
abstract class ResponseFactory<S extends Success> {
    private final YammerHttpResponse response;
    ResponseFactory(YammerHttpResponse response){
        this.response = response;
    }
    YammerHttpResponse getResponse(){
        return this.response;
    }
    abstract S onSuccess();
    Error onBadRequest(){
        String type = RegexUtil.extract(TYPE_REGEX_JSON, response.getEntityString());
        String message = RegexUtil.extract(MESSAGE_REGEX_JSON,response.getEntityString());
        System.out.println(response.getEntityString());
        return new Error.DefaultError(type,message);
    }
    private static final String TYPE_REGEX_JSON = "\"type\":\"(.*?)\"";
    private static final String MESSAGE_REGEX_JSON = "\"message\":\"(.*?)\"";

}
