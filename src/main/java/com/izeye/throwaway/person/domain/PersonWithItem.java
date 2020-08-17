package com.izeye.throwaway.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * {@link Person} with {@link Item}.
 *
 * @author Johnny Lim
 */
@Data
@AllArgsConstructor
public class PersonWithItem {

	private final Person person;
	private final Item item;

}
