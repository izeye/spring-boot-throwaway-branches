package learningtest.org.springframework.boot.test.rule;

import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link OutputCaptureExtension}.
 *
 * @author Johnny Lim
 */
@ExtendWith(OutputCaptureExtension.class)
class OutputCaptureRuleTests {

	@Test
	void testStandardOutput(CapturedOutput output) {
		String message = "Hello, world!";

		System.out.print(message);
		assertThat(output.toString()).isEqualTo(message);
	}

	@Test
	public void testStandardError(CapturedOutput output) {
		String message = "Hello, world!";

		System.err.print(message);
		assertThat(output.toString()).isEqualTo(message);
	}

}
