package com.izeye.throwaway;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Home {@link RestController}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping(path = "/")
public class HomeController {

	@Value("${greeting:Hello}")
	private String greeting;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/hello-world")
	public String helloWorld() {
		return this.greeting + ", world!";
	}

	@GetMapping("/httpServletRequest")
	public String httpServletRequest(HttpServletRequest request) {
		return request.toString();
	}

	@GetMapping("/throwException")
	public String throwException() {
		throw new RuntimeException("Expected.");
	}

	@GetMapping("/invokeRestTemplate")
	public String invokeRestTemplate() {
		return this.restTemplate.getForObject("https://www.google.com/", String.class);
	}

}
