package learningtest.org.springframework.boot.test.web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link TestRestTemplate}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = TestRestTemplateTests.Application.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class TestRestTemplateTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void test() {
		Person person = this.testRestTemplate.getForObject("/persons/1", Person.class);
		assertThat(person.getId()).isEqualTo(1L);
		assertThat(person.getFirstName()).isEqualTo("Johnny");
		assertThat(person.getLastName()).isEqualTo("Lim");
	}

	@SpringBootApplication
	@Import(PersonController.class)
	static class Application {
	}

	@RestController
	@RequestMapping(path = "/persons")
	private static class PersonController {

		@GetMapping("/{id}")
		public Person getPerson(@PathVariable long id) {
			Person person = new Person();
			person.setId(id);
			person.setFirstName("Johnny");
			person.setLastName("Lim");
			return person;
		}

	}

	@Data
	private static class Person {

		private Long id;
		private String firstName;
		private String lastName;

	}

}
