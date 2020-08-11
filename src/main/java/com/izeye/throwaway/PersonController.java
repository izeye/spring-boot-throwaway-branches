package com.izeye.throwaway;

import java.util.ArrayList;
import java.util.List;

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

	@GetMapping
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("1", "Johnny", "Lim"));
		return persons;
	}

}
