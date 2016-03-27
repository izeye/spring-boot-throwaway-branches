package com.izeye.throwaway.person.domain;

import java.util.Date;

/**
 * Created by izeye on 16. 3. 27..
 */
public abstract class TestDomainFactory {

	public static Person createPerson() {
		Person person = new Person();
		person.setId(1L);
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(35);
		person.setCreatedTime(new Date());
		return person;
	}
	
}
