package yammer4j;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

class MessagesImpl implements Messages {
    private final YammerHttpClient yammerHttpClient;
    MessagesImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }

    public Response<Json> getAllConversations(Integer olderThan, Integer newerThan, Threaded threaded, Integer limit)  {
        final ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,MESSAGES,generate(olderThan,newerThan,threaded,limit));
        final YammerHttpResponse response = yammerHttpClient.execute(apiQuery);
        return genetateJsonResponse(response);
    }

    public Response<Json> getMyFeed(Integer olderThan, Integer newerThan, Threaded threaded, Integer limit)  {
        final ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,MY_FEED,generate(olderThan,newerThan,threaded,limit));
        final YammerHttpResponse response = yammerHttpClient.execute(apiQuery);
        return genetateJsonResponse(response);
    }

    public Response<Json> getAlgorithmicFeed(Integer olderThan, Integer newerThan, Threaded threaded, Integer limit)  {
        final ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,ALGO,generate(olderThan,newerThan,threaded,limit));
        final YammerHttpResponse response = yammerHttpClient.execute(apiQuery);
        return genetateJsonResponse(response);
    }

    public Response<Json> getFollowingFeed(Integer olderThan, Integer newerThan, Threaded threaded, Integer limit)  {
        final ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,FOLLOWING,generate(olderThan,newerThan,threaded,limit));
        final YammerHttpResponse response = yammerHttpClient.execute(apiQuery);
        return genetateJsonResponse(response);
    }

    public Response<Json> getSentMessages(Integer olderThan, Integer newerThan, Threaded threaded, Integer limit)  {
        final ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,SENT,generate(olderThan,newerThan,threaded,limit));
        final YammerHttpResponse response = yammerHttpClient.execute(apiQuery);
        return genetateJsonResponse(response);
    }

    public Response<Json> getPrivateMessages(Integer olderThan, Integer newerThan, Threaded threaded, Integer limit)  {
        final ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,PRIVATE,generate(olderThan,newerThan,threaded,limit));
        final YammerHttpResponse response = yammerHttpClient.execute(apiQuery);
        return genetateJsonResponse(response);
    }

    public Response<Json> getReceivedMessages(Integer olderThan, Integer newerThan, Threaded threaded, Integer limit)  {
        final ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,RECEIVED,generate(olderThan,newerThan,threaded,limit));
        final YammerHttpResponse response = yammerHttpClient.execute(apiQuery);
        return genetateJsonResponse(response);
    }

    private Response<Json> genetateJsonResponse(final YammerHttpResponse response){
        return new YammerResponse<Json>(new ResponseFactory<Json>(response) {
            @Override
            Json onSuccess() {
                return new Json(this.response.getEntityString());
            };
        });
    }


    private List<NameValuePair> generate(Integer olderThan, Integer newerThan, Threaded threaded, Integer limit){
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
        if(olderThan != null){
            nameValuePairs.add(new BasicNameValuePair("older_than",String.valueOf(olderThan)));
        }
        if(olderThan != null){
            nameValuePairs.add(new BasicNameValuePair("newer_than",String.valueOf(newerThan)));
        }
        if(threaded != null){
            nameValuePairs.add(new BasicNameValuePair("threaded",threaded.toString().toLowerCase()));
            if(limit != null){
                nameValuePairs.add(new BasicNameValuePair("limit",String.valueOf(limit)));
            }
        }
        return nameValuePairs;
    }
}
