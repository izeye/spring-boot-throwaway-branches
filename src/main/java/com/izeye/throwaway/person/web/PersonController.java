package com.izeye.throwaway.person.web;

import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> getAll() {
		return personService.findAll();
	}

	@RequestMapping(path = "/{firstName}", method = RequestMethod.GET)
	public Person getByFirstName(@PathVariable String firstName) {
		return personService.findByFirstName(firstName);
	}
	
}
