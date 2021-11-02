package learningtest.org.springframework.boot.test.system;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link OutputCaptureExtension}.
 *
 * @author Johnny Lim
 */
class OutputCaptureExtensionTests {

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    void getOut(CapturedOutput output) {
        String message = "Hello, world!";
        System.out.println(message);
        assertThat(output).contains(message);
    }

}
