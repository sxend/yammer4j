package yammer4j.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtil {

		public final static String regexExtraction(String regex, String target) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(target);
			if (matcher.find()) {
				return matcher.group(1);
			} else {
				throw new IllegalArgumentException("not matching.");
			}
		}

}
