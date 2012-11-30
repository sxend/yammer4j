package yammer4j.opengraph;

import org.codehaus.jackson.annotate.JsonWriteNullProperties;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/29
 * Time: 20:25
 * To change this template use File | Settings | File Templates.
 */
public class Activity {

    private User actor;
    private String action;
    private Object object;
    private Boolean isPrivate;
    private String message;
    private User[] users;
    public User getActor(){return this.actor;}
    public String getAction(){return this.action;}
    public Object getObject(){return this.object;}
    public Boolean getPrivate(){return this.isPrivate;}
    public String getMessage(){return this.message;}
    public User[] getUsers(){return this.users;}
    public void setActor(User actor){this.actor = actor;}
    public void setAction(Action action){this.action = action == null ? null: action.getAction();}
    public void setObject(Object object){this.object = object;}
    public void setPrivate(Boolean isPrivate){this.isPrivate = isPrivate;}
    public void setMessage(String message){this.message = message;}
    public void setUsers(User[] users){this.users = users;}
    public static enum Action {
        CREATE("create"),
        UPDATE("update"),
        DELETE("delete"),
        FOLLOW("follow"),
        LIKE("like");
        private String action;
        private Action(String action){
            this.action = action;
        }
        public String getAction(){
            return this.action;
        }
    }
}
