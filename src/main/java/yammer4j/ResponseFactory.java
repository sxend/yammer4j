package yammer4j;

/**
 * User: sxend
 * Date: 12/12/07
 * Time: 11:59
 */
abstract class ResponseFactory<S extends Success> {
    protected final YammerHttpResponse response;
    ResponseFactory(YammerHttpResponse response){
        this.response = response;
    }

    abstract S onSuccess();
    Error onBadRequest(){
        String type = RegexUtil.extract(TYPE_REGEX_JSON, response.getEntityString());
        String message = RegexUtil.extract(MESSAGE_REGEX_JSON,response.getEntityString());
        return new Error(type == null ? "BadRequest." : type,message == null?"inValidParameter.":message);
    }
    Error onUnAuthorized() {
        String code = RegexUtil.extract(CODE_REGEX_JSON,response.getEntityString());
        String message = RegexUtil.extract(MESSAGE_REGEX_JSON,response.getEntityString());
        return new Error(code == null ? "UnAuthorized." : code ,message == null?"inValidParameter.":message);
    }

    private static final String TYPE_REGEX_JSON = "\"type\":\"(.*?)\"";
    private static final String MESSAGE_REGEX_JSON = "\"message\":\"(.*?)\"";
    private static final String CODE_REGEX_JSON = "\"code\":\"(.*?)\"";

    YammerHttpResponse getResponse() {
        return this.response;
    }
}
