package com.izeye.throwaway;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.Identifiable;

/**
 * Created by izeye on 15. 12. 12..
 */
@Data
@AllArgsConstructor
public class IdentifiablePerson implements Identifiable<Long> {

	private Long id;
	private String firstName;
	private String lastName;
	
}
