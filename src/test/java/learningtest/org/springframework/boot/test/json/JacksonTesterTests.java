package learningtest.org.springframework.boot.test.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 28..
 */
public class JacksonTesterTests {
	
	JacksonTester<TestObject> json;
	
	@Before
	public void setUp() {
		ObjectMapper mapper = new ObjectMapper();
		JacksonTester.initFields(this, mapper);
	}
	
	@Test
	public void test() throws IOException {
		TestObject object = new TestObject();
		object.setName("Spring");
		object.setAge(123);
		assertThat(json.write(object)).isEqualToJson("test.json");
	}
	
}
