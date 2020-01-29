package learningtest.org.springframework.boot.test.rule;

import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.test.system.OutputCaptureRule;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link OutputCaptureRule}.
 *
 * @author Johnny Lim
 */
public class OutputCaptureRuleTests {

	@Rule
	public OutputCaptureRule outputCaptureRule = new OutputCaptureRule();

	@Test
	public void testStandardOutput() {
		String message = "Hello, world!";

		System.out.print(message);
		assertThat(this.outputCaptureRule.toString()).isEqualTo(message);
	}

	@Test
	public void testStandardError() {
		String message = "Hello, world!";

		System.err.print(message);
		assertThat(this.outputCaptureRule.toString()).isEqualTo(message);
	}

}
