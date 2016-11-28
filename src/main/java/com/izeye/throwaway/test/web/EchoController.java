package com.izeye.throwaway.test.web;

import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} for the echo service.
 *
 * @author Johnny Lim
 */
@RestController
@Validated
public class EchoController {

	@GetMapping("/echo")
	public String echo(@RequestParam @Size(min = 10) String message) {
		return message;
	}

}
