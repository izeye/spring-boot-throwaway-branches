package com.izeye.throwaway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by izeye on 15. 12. 12..
 */
@RestController
public class GreetingController {
	
	private static final String TEMPLATE = "Hello, %s!";
	
	@RequestMapping("/greeting")
	public ResponseEntity<Greeting> greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}
	
}
