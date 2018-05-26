package com.izeye.throwaway;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} for {@link Person}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping(path = "/persons")
public class PersonController {

	// curl -v -XPOST -u "user:secret" -H "Accept: application/json" -H "Content-type: application/json" -d '{"firstName": "Johnny", "lastName": "Lim"}' "http://localhost:8080/persons"
	@PostMapping
	public Person post(@RequestBody Person person) {
		System.out.println(person);
		return person;
	}

}
