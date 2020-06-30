package learningtest.org.springframework.boot.test.json;

import org.springframework.boot.test.json.BasicJsonTester;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 28..
 */
class BasicJsonTesterTests {
	
	BasicJsonTester json = new BasicJsonTester(getClass());
	
	@Test
	void test() throws IOException {
		assertThat(json.from("test.json")).extractingJsonPathStringValue("@.name")
				.isEqualTo("Spring");
	}
	
}
