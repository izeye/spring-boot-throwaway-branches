package com.izeye.throwaway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

/**
 * Created by izeye on 15. 12. 12..
 */
@Controller
@RequestMapping(path = "/person-resources")
public class PersonResourceController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PersonResource>> personResources() {
		PoJoPerson person = new PoJoPerson(1L, "Johnny", "Lim");
		List<PoJoPerson> persons = Collections.singletonList(person);

		PojoPersonResourceAssembler assembler = new PojoPersonResourceAssembler();
		List<PersonResource> personResources = assembler.toResources(persons);

		return new ResponseEntity<List<PersonResource>>(personResources, HttpStatus.OK);
	}
	
}
