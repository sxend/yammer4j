package yammer4j;

public interface Users {
    Response<Json> getUsers(Integer page,String letter,SortBy sortBy);
    Response<Json> getCurrentUser();
    Response<Json> getUserData(Long userId);
    Response<Json> getUserDataByEmail(String emailAdr,boolean includeFollowedUsers,boolean includeFollowedTags,boolean includeGroupMemberships);
    Response<Json> getUserInGroup(Long userId,Integer page);
    static final String USERS_BASE = ApiUrl.API_BASE_URL + "/users";
    static final String USERS = USERS_BASE + ".json";
    static final String CURRENT = USERS_BASE + "/current.json";
    static final String USER_DATA = USERS_BASE + "/%s.json";
    static final String BY_EMAIL = USERS_BASE + "/by_email.json?email=%s";
    static final String IN_GROUP = USERS_BASE + "/in_group/%s.json";

    public enum SortBy {
        MESSAGES,
        FOLLOWERS;
    }
}
