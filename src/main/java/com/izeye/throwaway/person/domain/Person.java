package com.izeye.throwaway.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person.
 *
 * @author Johnny Lim
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private Long id;
	private String firstName;
	private String lastName;

}
