package com.izeye.throwaway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

	@GetMapping
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Johnny", "Lim"));
		return persons;
	}

	@GetMapping("/{id}")
	public Person get(@PathVariable String id) {
		return new Person("Johnny", "Lim");
	}

	@PostMapping("/echo")
	public Person echo(@RequestHeader("My-Header") String myHeader, @RequestBody Person person) {
		return person;
	}

}
