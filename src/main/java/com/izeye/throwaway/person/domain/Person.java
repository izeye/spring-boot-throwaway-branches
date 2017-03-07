package com.izeye.throwaway.person.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by izeye on 15. 9. 19..
 */
@Data
public class Person {
	
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	
	private Date createdTime;

	public String getLastName() {
		return this.lastName + " from getter";
	}
	
}
