package com.izeye.throwaway.person.web;

import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by izeye on 15. 10. 1..
 */
@RestController
@RequestMapping(path = "/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> getAll() {
		return personService.findAll();
	}
	
	@GetMapping("/{id}")
//	@CrossOrigin(origins = "http://localhost:28080")
	public Person findById(@PathVariable("id") Person person) {
		return person;
	}

	@GetMapping( "/search")
	public Person findByFirstName(@RequestParam String firstName) {
		return personService.findByFirstName(firstName);
	}
	
}
