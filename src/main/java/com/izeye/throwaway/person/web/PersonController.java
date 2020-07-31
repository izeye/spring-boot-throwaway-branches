package com.izeye.throwaway.person.web;

import java.util.List;

import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * {@link RestController} for {@link Person}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping
	public Mono<List<PersonDTO>> getPersons() {
		return this.personService.getPersons()
				.map((person) -> new PersonDTO(person.getFirstName(), person.getLastName()))
				.collectList();
	}

}
