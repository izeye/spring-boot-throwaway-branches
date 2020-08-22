package com.izeye.throwaway;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		LongStream.range(0, 100).forEach((id) -> persons.add(this.personService.get(id)));
		return persons;
	}

}
