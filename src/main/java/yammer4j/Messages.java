package yammer4j;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface Messages {
    public static final String Massages ="/messages.json";

    public String get() throws ClientProtocolException, IOException;
}
