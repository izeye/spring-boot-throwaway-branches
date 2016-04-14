package com.izeye.throwaway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
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
@Slf4j
public class PersonController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> getAll() {
		Person person = new Person();
		person.setId(1L);
		PersonName name = new PersonName();
		name.setFirstName("Johnny");
		name.setLastName("Lim");
		person.setName(name);
		person.setAge(35);
		person.setCreatedTime(new Date());
		
		return Collections.singletonList(person);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Person person) {
		log.info("Adding person: {}", person);
	}
	
}
