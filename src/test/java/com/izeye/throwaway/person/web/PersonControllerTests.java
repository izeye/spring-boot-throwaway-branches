package com.izeye.throwaway.person.web;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.service.PersonService;

import static org.mockito.BDDMockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link PersonController}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@Before
	public void setUp() {
		Person person1 = new Person();
		person1.setFirstName("Johnny");

		Person person2 = new Person();
		person2.setFirstName("John");

		when(this.personService.findAll()).thenReturn(Arrays.asList(person1, person2));
	}

	@Test
	public void test() throws Exception {
		this.mockMvc.perform(get("/persons"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].first_name").value("Johnny"))
				.andExpect(jsonPath("$.[1].first_name").value("John"));
	}

}
