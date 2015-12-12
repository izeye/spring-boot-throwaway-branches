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
@RequestMapping(path = "/pojo-persons")
public class PojoPersonController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PoJoPerson> showAll() {
		return null;
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PoJoPerson> show(@PathVariable long id) {
		return null;
	}
	
}
