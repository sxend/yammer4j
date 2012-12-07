package yammer4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: sxend
 * Date: 12/12/06
 * Time: 20:20
 */
class RegexUtil {

    static String extract(String regex, String target) {
        Matcher matcher = Pattern.compile(regex).matcher(target);
        return matcher.find() ? matcher.group(1) : null;
    }
}
