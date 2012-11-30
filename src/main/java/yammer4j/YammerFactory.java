package yammer4j;

/**
 * Created with IntelliJ IDEA.
 * User: A12184
 * Date: 12/11/30
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public final class YammerFactory {

    public YammerFactory(){}

    public Yammer getInstance(){
        return new YammerImpl();
    }
}
