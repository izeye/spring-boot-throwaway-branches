package com.izeye.throwaway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Home {@link RestController}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping(path = "/")
public class HomeController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello, world!";
	}

	@GetMapping("/throwException")
	public String throwException() {
		throw new RuntimeException("Expected.");
	}

}
