package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/28
 * Time: 20:03
 * To change this template use File | Settings | File Templates.
 */
public interface Messages {
    String getAllConversations(AccessToken accessToken,ResponseType type);
    String getMyFeed(AccessToken accessToken,ResponseType type);
    String getAlgorithmicFeed(AccessToken accessToken,ResponseType type);
    String getFollowingFeed(AccessToken accessToken,ResponseType type);
    String getSentMessages(AccessToken accessToken);
    String getPrivateMessages(AccessToken accessToken);
    String getReceivedMessages(AccessToken accessToken);

    String postMessages(AccessToken accessToken);
    String createPendingAttachment(AccessToken accessToken);
    String removePendingAttachment(AccessToken accessToken);

}
