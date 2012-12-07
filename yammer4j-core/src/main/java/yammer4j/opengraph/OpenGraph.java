package yammer4j.opengraph;

import yammer4j.response.AccessToken;


public interface OpenGraph {

    public Boolean submitActivity(AccessToken accessToken, Activity... activities);

}
