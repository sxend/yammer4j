package yammer4j;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

class UsersImpl implements Users {
    private final YammerHttpClient yammerHttpClient;

    UsersImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }

    public Response<Json> getUsers(Integer page, String letter, SortBy sortBy) {
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        nvp.add(new BasicNameValuePair("page",String.valueOf(page)));
        nvp.add(new BasicNameValuePair("letter",letter));
        nvp.add(new BasicNameValuePair("sort_by",sortBy.name().toLowerCase()));
        ApiQuery query = new ApiQuery(ApiQuery.Method.GET,USERS,nvp);
        YammerHttpResponse response = this.yammerHttpClient.execute(query);
        return new YammerResponse<Json>(Json.getJsonResponseFactory(response));
    }

    public Response<Json> getCurrentUser() {
        ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,CURRENT,null);
        YammerHttpResponse response = this.yammerHttpClient.execute(apiQuery);
        return new YammerResponse<Json>(Json.getJsonResponseFactory(response));
    }

    public Response<Json> getUserData(Long userId) {
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        nvp.add(new BasicNameValuePair("user_id",String.valueOf(userId)));
        ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,CURRENT,nvp);
        YammerHttpResponse response = this.yammerHttpClient.execute(apiQuery);
        return new YammerResponse<Json>(Json.getJsonResponseFactory(response));
    }

    public Response<Json> getUserDataByEmail(String emailAdr,
                                             boolean includeFollowedUsers,
                                             boolean includeFollowedTags,
                                             boolean includeGroupMemberships) {
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        nvp.add(new BasicNameValuePair("email",String.valueOf(emailAdr)));
        nvp.add(new BasicNameValuePair("include_followed_users",String.valueOf(includeFollowedUsers)));
        nvp.add(new BasicNameValuePair("include_followed_tags",String.valueOf(includeFollowedTags)));
        nvp.add(new BasicNameValuePair("include_group_memberships",String.valueOf(includeGroupMemberships)));
        ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,CURRENT,nvp);
        YammerHttpResponse response = this.yammerHttpClient.execute(apiQuery);
        return new YammerResponse<Json>(Json.getJsonResponseFactory(response));
    }

    public Response<Json> getUserInGroup(Long userId, Integer page) {
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        nvp.add(new BasicNameValuePair("user_id",String.valueOf(userId)));
        nvp.add(new BasicNameValuePair("page",String.valueOf(page)));
        ApiQuery apiQuery = new ApiQuery(ApiQuery.Method.GET,CURRENT,nvp);
        YammerHttpResponse response = this.yammerHttpClient.execute(apiQuery);
        return new YammerResponse<Json>(Json.getJsonResponseFactory(response));
    }
}
