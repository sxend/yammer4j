package yammer4j;

import java.util.Date;

public class JUnitResultUtil {

	public static void timeStamp() {
		System.out.println(new Date(System.currentTimeMillis()).toString());

	}

	private static void toString(boolean flag, Object object) {
		if (flag) {
			System.out.println(object.toString());
		}
	}

	public static void toString(boolean flag, Object... objects) {
		for (Object object : objects) {
			toString(flag, object);
		}
	}

}
