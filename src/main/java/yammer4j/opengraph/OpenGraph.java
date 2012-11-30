package yammer4j.opengraph;

import yammer4j.AccessToken;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/28
 * Time: 20:07
 * To change this template use File | Settings | File Templates.
 */
public interface OpenGraph {

    public Boolean submitActivity(AccessToken accessToken,Activity... activities);

}
