package learningtest.org.springframework.boot.test.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.GsonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 28..
 */
class GsonTesterTests {
	
	GsonTester<TestObject> json;
	
	@BeforeEach
	void setUp() {
		Gson gson = new GsonBuilder().create();
		GsonTester.initFields(this, gson);
	}
	
	@Test
	void test() throws IOException {
		TestObject object = new TestObject();
		object.setName("Spring");
		object.setAge(123);
		assertThat(json.write(object)).isEqualToJson("test.json");
	}
	
}
