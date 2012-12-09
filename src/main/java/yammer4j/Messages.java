package yammer4j;


public interface Messages {
    Response<Json> getAllConversations(Integer olderThan,Integer newerThan,Threaded threaded,Integer limit) ;
    Response<Json> getMyFeed(Integer olderThan,Integer newerThan,Threaded threaded,Integer limit) ;
    Response<Json> getAlgorithmicFeed(Integer olderThan,Integer newerThan,Threaded threaded,Integer limit) ;
    Response<Json> getFollowingFeed(Integer olderThan,Integer newerThan,Threaded threaded,Integer limit) ;
    Response<Json> getSentMessages(Integer olderThan,Integer newerThan,Threaded threaded,Integer limit) ;
    Response<Json> getPrivateMessages(Integer olderThan,Integer newerThan,Threaded threaded,Integer limit) ;
    Response<Json> getReceivedMessages(Integer olderThan,Integer newerThan,Threaded threaded,Integer limit) ;

    public static enum Threaded {
        TRUE,EXTENDED;
    }
    static final String MESSAGES_BASE = ApiUrl.API_BASE_URL+ "/messages";
    static final String MESSAGES = MESSAGES_BASE + ".json";
    static final String MY_FEED = MESSAGES_BASE + "/my_feed.json";
    static final String ALGO = MESSAGES_BASE + "/algo.json";
    static final String FOLLOWING = MESSAGES_BASE + "/following.json";
    static final String SENT = MESSAGES_BASE + "/sent.json";
    static final String PRIVATE = MESSAGES_BASE + "/private.json";
    static final String RECEIVED = MESSAGES_BASE + "/received.json";


//
//    String postMessages();
//    String createPendingAttachment();
//    String removePendingAttachment();

}
