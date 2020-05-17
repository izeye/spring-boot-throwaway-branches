package learningtest.org.springframework.util;

import org.springframework.util.Assert;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

/**
 * Tests for {@link Assert}.
 *
 * @author Johnny Lim
 */
class AssertTests {
	
	@Test
	void testState() {
		String field1 = null;
		String[] existingBeans1 = new String[100];
		Assert.state(field1 == null || existingBeans1.length == 1, "Error");
		
		String field2 = "field";
		String[] existingBeans2 = new String[1];
		Assert.state(field2 == null || existingBeans2.length == 1, "Error");
		
		String field3 = "field";
		String[] existingBeans3 = new String[100];
		assertThatIllegalStateException()
				.isThrownBy(() -> Assert.state(field3 == null || existingBeans3.length == 1, "Error"))
				.withMessage("Error");
	}
	
}
