package com.izeye.throwaway.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} for the echo service.
 *
 * @author Johnny Lim
 */
@RestController
public class EchoController {

	@GetMapping("/echo")
	public String echo(@RequestParam String message) {
		return message;
	}

}
