package learningtest.org.springframework.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.util.Assert;

/**
 * Created by izeye on 16. 5. 10..
 */
public class AssertTests {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testState() {
		String field = null;
		String[] existingBeans = new String[100];
		Assert.state(field == null || existingBeans.length == 1, "Error");
		
		field = "field";
		existingBeans = new String[1];
		Assert.state(field == null || existingBeans.length == 1, "Error");
		
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("Error");

		field = "field";
		existingBeans = new String[100];
		Assert.state(field == null || existingBeans.length == 1, "Error");
	}
	
}
