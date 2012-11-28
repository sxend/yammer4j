package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/28
 * Time: 20:03
 * To change this template use File | Settings | File Templates.
 */
public interface Messages {
    Object getAllConversations(AccessToken accessToken);
    Object getMyFeed(AccessToken accessToken);
    Object getAlgorithmicFeed(AccessToken accessToken);
    Object getFollowingFeed(AccessToken accessToken);
    Object getSentMessages(AccessToken accessToken);
    Object getPrivateMessages(AccessToken accessToken);
    Object getReceivedMessages(AccessToken accessToken);

    Object postMessages(AccessToken accessToken);
    Object createPendingAttachment(AccessToken accessToken);
    Object removePendingAttachment(AccessToken accessToken);

}
