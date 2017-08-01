package learningtest.org.springframework.boot.test.json;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class JacksonTesterTests {

	@Autowired
	private JacksonTester<Person> json;

	@Test
	public void testParseObject() throws IOException {
		String json = "{\"firstName\": \"Johnny\", \"lastName\": \"Lim\"}";

		Person person = this.json.parseObject(json);

		assertThat(person.getFirstName()).isEqualTo("Johnny");
		assertThat(person.getLastName()).isEqualTo("Lim");
	}

	@Data
	private static class Person {

		private String firstName;
		private String lastName;

	}

	@Configuration
	static class Config {
	}

}
