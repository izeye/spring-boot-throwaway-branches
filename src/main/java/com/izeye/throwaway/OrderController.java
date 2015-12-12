package com.izeye.throwaway;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by izeye on 15. 12. 12..
 */
@Controller
@ExposesResourceFor(Order.class)
@RequestMapping(path = "/orders")
public class OrderController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Order> orders() {
		return null;
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> order(@PathVariable long id) {
		return null;
	}
	
}
