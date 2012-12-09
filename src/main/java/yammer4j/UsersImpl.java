package yammer4j;

class UsersImpl implements Users {
    private final YammerHttpClient yammerHttpClient;

    UsersImpl(YammerHttpClient yammerHttpClient) {
        this.yammerHttpClient = yammerHttpClient;
    }

    public Response<Json> getUsers(Integer page, String letter, SortBy sortBy) {
        return null;  //TODO
    }

    public Response<Json> getCurrentUser() {
        return null;  //TODO
    }

    public Response<Json> getUserData(Long userId) {
        return null;  //TODO
    }

    public Response<Json> getUserDataByEmail(String emailAdr, boolean includeFollowedUsers, boolean includeFollowedTags, boolean includeGroupMemberships) {
        return null;  //TODO
    }

    public Response<Json> getUserInGroup(Long userId, Integer page) {
        return null;  //TODO
    }
}
