package learningtest.org.springframework.boot.test.rule;

import org.springframework.boot.test.rule.OutputCapture;

import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link OutputCapture}.
 *
 * @author Johnny Lim
 */
public class OutputCaptureTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testStandardOutput() {
		String message = "Hello, world!";

		System.out.print(message);
		assertThat(this.outputCapture.toString()).isEqualTo(message);
	}

	@Test
	public void testStandardError() {
		String message = "Hello, world!";

		System.err.print(message);
		assertThat(this.outputCapture.toString()).isEqualTo(message);
	}

}
