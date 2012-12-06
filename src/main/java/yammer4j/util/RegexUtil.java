package yammer4j.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 20:20
 */
public class RegexUtil {

    public static String extract(String regex, String target) {
        Matcher matcher = Pattern.compile(regex).matcher(target);
        return matcher.find() ? matcher.group(1) : null;
    }
}
