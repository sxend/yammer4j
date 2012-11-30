package yammer4j.opengraph;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import yammer4j.AccessToken;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 20:58
 * To change this template use File | Settings | File Templates.
 */
public class OpenGraphImpl implements OpenGraph {
    private final ObjectMapper om = new ObjectMapper()
            .configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false)
            .configure(SerializationConfig.Feature.WRITE_EMPTY_JSON_ARRAYS, false)
            .configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);

    public Boolean submitActivity(AccessToken accessToken, Activity... activities) {
        String query = null;
        try {
            query = om.writeValueAsString(activities.length > 1 ? activities : activities[0]);
        } catch (Exception e) {
        }
        return null;
    }
}
