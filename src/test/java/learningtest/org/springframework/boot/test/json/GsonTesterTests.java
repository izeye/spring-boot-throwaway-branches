package learningtest.org.springframework.boot.test.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.GsonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 28..
 */
public class GsonTesterTests {
	
	GsonTester<TestObject> json;
	
	@Before
	public void setUp() {
		Gson gson = new GsonBuilder().create();
		GsonTester.initFields(this, gson);
	}
	
	@Test
	public void test() throws IOException {
		TestObject object = new TestObject();
		object.setName("Spring");
		object.setAge(123);
		assertThat(json.write(object)).isEqualToJson("test.json");
	}
	
}
