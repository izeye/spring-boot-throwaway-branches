package com.izeye.throwaway.person.domain;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by izeye on 16. 3. 27..
 */
public abstract class TestDomainFactory {
	
	private static final AtomicLong COUNTER = new AtomicLong(1);

	public static Person createPerson() {
		Person person = new Person();
		person.setId(COUNTER.getAndIncrement());
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(35);
		person.setCreatedTime(new Date());
		return person;
	}
	
}
