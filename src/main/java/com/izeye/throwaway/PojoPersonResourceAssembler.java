package com.izeye.throwaway;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by izeye on 15. 12. 12..
 */
public class PojoPersonResourceAssembler
		extends ResourceAssemblerSupport<PoJoPerson, PersonResource> {
	
	public PojoPersonResourceAssembler() {
		super(PersonResourceController.class, PersonResource.class);
	}

	@Override
	public PersonResource toResource(PoJoPerson person) {
		PersonResource personResource = createResourceWithId(person.getId(), person);
		personResource.setFirstName(person.getFirstName());
		personResource.setLastName(person.getLastName());
		return personResource;
	}
	
}
