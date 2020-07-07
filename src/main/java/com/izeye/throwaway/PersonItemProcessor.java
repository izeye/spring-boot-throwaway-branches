package com.izeye.throwaway;

import org.springframework.batch.item.ItemProcessor;
import lombok.extern.slf4j.Slf4j;

/**
 * {@link ItemProcessor} for {@link Person}.
 *
 * @author Johnny Lim
 */
@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person person) throws Exception {
		Person transformedPerson = new Person(person.getFirstName().toUpperCase(), person.getLastName().toLowerCase());
		log.info("Converting ({}) into ({})", person, transformedPerson);
		return transformedPerson;
	}

}
