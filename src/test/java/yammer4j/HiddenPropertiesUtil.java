package yammer4j;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class HiddenPropertiesUtil {
	private static final String BUNDLE_NAME = "test-hidden"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private HiddenPropertiesUtil() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
