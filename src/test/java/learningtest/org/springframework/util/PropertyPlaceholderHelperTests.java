package learningtest.org.springframework.util;

import org.springframework.util.PropertyPlaceholderHelper;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 12. 23..
 */
class PropertyPlaceholderHelperTests {
	
	@Test
	void testReplacePlaceholders() {
		PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper("{", "}");
		Properties properties = new Properties();
		properties.setProperty("name", "Johnny");
		String result = propertyPlaceholderHelper.replacePlaceholders("Hello, {name}!", properties);
		assertThat(result, is("Hello, Johnny!"));
	}
	
}
