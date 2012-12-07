package yammer4j;

import yammer4j.response.Success;
import yammer4j.response.Error;
import yammer4j.util.RegexUtil;

/**
 * User: sxend
 * Date: 12/12/07
 * Time: 11:59
 */
public abstract class ResponseFactory<S extends Success> {
    private final YammerHttpResponse response;
    public ResponseFactory(YammerHttpResponse response){
        this.response = response;
    }
    public YammerHttpResponse getResponse(){
        return this.response;
    }
    public abstract S onSuccess();
    public Error onBadRequest(){
        String type = RegexUtil.extract(TYPE_REGEX_JSON, response.getEntityString());
        type = type == null ? RegexUtil.extract(TYPE_REGEX_XML,response.getEntityString()) : type;
        String message = RegexUtil.extract(MESSAGE_REGEX_JSON,response.getEntityString());//TODO
        message = message == null ? RegexUtil.extract(MESSAGE_REGEX_XML,response.getEntityString()) : message;
        System.out.println(response.getEntityString());
        return new Error.DefaultError(type,message);
    }
    private static final String TYPE_REGEX_JSON = "\"type\":\"(.*?)\"";
    private static final String TYPE_REGEX_XML = "<type>(.*?)</type>";

    private static final String MESSAGE_REGEX_JSON = "\"message\":\"(.*?)\"";
    private static final String MESSAGE_REGEX_XML = "<message>(.*?)</message>";

}
