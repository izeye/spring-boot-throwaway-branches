package com.izeye.throwaway.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.izeye.throwaway.domain.Person;
import com.izeye.throwaway.service.PersonService;

/**
 * {@link RestController} for {@link Person}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping(path = "/persons")
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping(path = "/{id}")
	public Person get(@PathVariable Long id) {
		return this.personService.get(id);
	}

	// NOTE: This is necessary for Spring Boot 2.0.x apps.
	@GetMapping(path = "/{id}/forceContentTypeUtf8Charset", produces = "application/json; charset=utf-8")
	public Person getWithContentTypeUtf8Charset(@PathVariable Long id) {
		return this.personService.get(id);
	}

}
