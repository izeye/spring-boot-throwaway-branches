package com.izeye.throwaway.domain;

import lombok.Data;
import org.springframework.core.style.ToStringCreator;

/**
 * Created by izeye on 15. 9. 19..
 */
@Data
public class Person {
	
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	
	@Override
	public String toString() {
		return new ToStringCreator(this)
				.append("id", this.id)
				.append("firstName", this.firstName)
				.append("lastName", this.lastName)
				.append("age", this.age).toString();
	}
	
}
