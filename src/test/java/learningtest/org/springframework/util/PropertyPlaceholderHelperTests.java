package learningtest.org.springframework.util;

import org.junit.Test;
import org.springframework.util.PropertyPlaceholderHelper;

import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 12. 23..
 */
public class PropertyPlaceholderHelperTests {
	
	@Test
	public void testReplacePlaceholders() {
		PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper("{", "}");
		Properties properties = new Properties();
		properties.setProperty("name", "Johnny");
		String result = propertyPlaceholderHelper.replacePlaceholders("Hello, {name}!", properties);
		assertThat(result, is("Hello, Johnny!"));
	}
	
}
