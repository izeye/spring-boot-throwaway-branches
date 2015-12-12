package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by izeye on 15. 12. 12..
 */
@Controller
@RequestMapping(path = "/payment")
public class PaymentController {
	
	@Autowired
	private EntityLinks entityLinks;
	
	@RequestMapping(path = "/{orderId}", method = RequestMethod.PUT)
	public ResponseEntity<Order> payment(@PathVariable long orderId) {
		Order order = new Order();
		Link link = entityLinks.linkToSingleResource(Order.class, orderId);
		order.add(link);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
}
