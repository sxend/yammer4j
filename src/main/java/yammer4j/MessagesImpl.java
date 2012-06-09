package yammer4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

final class MessagesImpl extends AbstractYammerApi
        implements Messages {

    protected MessagesImpl(YammerHttpClient client) {
        super(client);
    }

    public String get() throws ClientProtocolException, IOException {
        HttpGet httpGet = new HttpGet(BASE_API_URL + Massages);
        HttpResponse httpResponse=client.request(httpGet);
        return EntityUtils.toString(httpResponse.getEntity());
    }

}
