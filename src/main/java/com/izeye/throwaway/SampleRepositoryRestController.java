package com.izeye.throwaway;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Sample {@link RepositoryRestController}.
 *
 * @author Johnny Lim
 */
@RepositoryRestController
@RequestMapping(path = "/sample-repository-rest-controller")
public class SampleRepositoryRestController {

	@GetMapping("/persons/{id}")
	@ResponseBody
	public Person findPerson(@PathVariable Long id) {
		Person person = new Person();
		person.setId(id);
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(20);
		return person;
	}

}
