package com.izeye.throwaway;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by izeye on 15. 10. 1..
 */
@RestController
@RequestMapping(path = "/persons")
public class PersonController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> getAll() {
		Person person = createDummyPerson();
		return Collections.singletonList(person);
	}

	@RequestMapping(path = "/{firstName}", method = RequestMethod.GET)
	public Person getByFirstName(@PathVariable String firstName) {
		Person person = createDummyPerson();
		person.setFirstName(firstName);
		return person;
	}

	private Person createDummyPerson() {
		Person person = new Person();
		person.setId(1L);
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(35);
		person.setCreatedTime(new Date());
		return person;
	}
	
}
