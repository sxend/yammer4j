package yammer4j;


import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * User: sxend
 * Date: 12/12/04
 * Time: 12:50
 */
class ApiQuery {
    private static final String QUES = new String("?");
    private static final String AMP = new String("&");
    private static final String EQ = new String("=");

    private final Method method;
    private final String url;
    private final List<NameValuePair> params;

    ApiQuery(Method method, String url, List<NameValuePair> params) {
        this.method = method;
        this.url = url == null ? "" : url;
        this.params = params;
    }

    enum Method {
        GET, PUT, DELETE, POST;
    }

    Method getMethod() {
        return method;
    }

    String getUrl() {
        return url;
    }

    String createRequestUrl() {
        StringBuilder requestUrl = new StringBuilder(url);
        if(this.params == null)
            return requestUrl.toString();

        String prefix = QUES;
        for (ListIterator<NameValuePair> li = params.listIterator(); li.hasNext(); ) {
            NameValuePair nameValuePair = li.next();
            requestUrl.append(prefix).append(nameValuePair.getName()).append(EQ).append(nameValuePair.getValue());
            prefix = AMP;
//            requestUrl.append(li.previousIndex() == 0 ? "?" : "").append(nvp.getName()).append("=").append(nvp.getValue()).append(li.nextIndex() == params.size() ? "" : "&");
        }
        return requestUrl.toString();
    }

}
