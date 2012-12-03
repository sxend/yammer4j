package yammer4j_old;

import yammer4j.opengraph.Activity;
import yammer4j.opengraph.Object;
import yammer4j.opengraph.User;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String... args) throws Exception {
        Activity activity = new Activity();
        activity.setAction(Activity.Action.CREATE);
        User user = new User();
//        user.setEmail("email");
        user.setName("name");
        activity.setActor(user);
        activity.setMessage("message");
        Object obj = new Object();
        obj.setUrl("url");
        obj.setDescription("description");
        obj.setImage("image");
        obj.setTitle("title");
        obj.setType(Object.ObjectType.IMAGE);
        activity.setObject(obj);
        activity.setPrivate(Boolean.TRUE);
        User[] users = new User[2];
        users[0] = new User();
        users[0].setName("a");
        users[1] = new User();
        users[1].setEmail("b");
        activity.setUsers(users);

        new Main().hoge(new Activity[]{activity});
    }

    public void hoge(Activity... activities) {

        try {
//            activities.length > 1 ?om.writeValueAsString(activities) : om.writeValueAsString(activities[0]);
        } catch (Exception e) {
        }
    }

    public void fuga() {
        yammer4j.Yammer yammer = yammer4j.Yammer.getInstance();
    }

}
