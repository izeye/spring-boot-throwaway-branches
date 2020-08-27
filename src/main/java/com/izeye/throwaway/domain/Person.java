package com.izeye.throwaway.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import lombok.Data;

/**
 * Person.
 *
 * @author Johnny Lim
 */
@Data
@Document(indexName = "persons")
public class Person {

	@Id
	private final Long id;
	private final String firstName;
	private final String lastName;

}
