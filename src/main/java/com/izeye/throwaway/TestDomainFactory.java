package com.izeye.throwaway;

import java.util.Date;

/**
 * Created by izeye on 16. 4. 14..
 */
public abstract class TestDomainFactory {
	
	public static Person createPerson() {
		Person person = new Person();
		person.setId(1L);
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(36);
		person.setCreatedTime(new Date());
		return person;
	}
	
}
