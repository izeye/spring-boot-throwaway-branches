package com.izeye.throwaway;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by izeye on 15. 12. 12..
 */
@Controller
@RequestMapping(path = "/identifiable-persons")
public class IdentifiablePersonController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<IdentifiablePerson> showAll() {
		return null;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<IdentifiablePerson> show(@PathVariable long id) {
		return null;
	}
	
}
