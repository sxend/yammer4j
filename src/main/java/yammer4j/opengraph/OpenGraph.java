package yammer4j.opengraph;

import yammer4j.AccessToken;


public interface OpenGraph {

    public Boolean submitActivity(AccessToken accessToken, Activity... activities);

}
