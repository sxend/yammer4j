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

    private final Method method;
    private final String url;
    private final List<NameValuePair> params;

    ApiQuery(Method method, String url, List<NameValuePair> params) {
        this.method = method;
        this.url = url == null ? "" : url;
        this.params = params == null ? new ArrayList<NameValuePair>() : params;
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

        for (ListIterator<NameValuePair> li = params.listIterator(); li.hasNext(); ) {
            NameValuePair nvp = li.next();
            requestUrl.append(li.previousIndex() == 0 ? "?" : "").append(nvp.getName()).append("=").append(nvp.getValue()).append(li.nextIndex() == params.size() ? "" : "&");
        }
        return requestUrl.toString();
    }

}
