package yammer4j.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtil {

    public static final String regexExtraction(String regex, String target, int groupNum) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);
        if (matcher.find()) {
            return matcher.group(groupNum);
        } else {
            throw new IllegalArgumentException("not matching.");
        }
    }

    public static final String regexExtraction(String regex, String target) {
        return regexExtraction(regex, target, 1);
    }

}
