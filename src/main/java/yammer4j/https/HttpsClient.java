package yammer4j.https;


import yammer4j.https.request.HttpsRequest;
import yammer4j.https.request.RequestMethod;
import yammer4j.https.response.HttpsResponse;


public interface HttpsClient {

    public HttpsResponse execute(HttpsRequest httpsRequest);
}
