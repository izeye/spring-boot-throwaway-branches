package com.izeye.throwaway;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by izeye on 15. 12. 12..
 */
@Data
public class PersonResource extends ResourceSupport {

	private String firstName;
	private String lastName;
	
}
