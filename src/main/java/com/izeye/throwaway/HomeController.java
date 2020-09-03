package com.izeye.throwaway;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

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

	private final RestTemplate restTemplate;

	public HomeController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello, world!";
	}

	@GetMapping("/httpServletRequest")
	public Map<String, Map<String, ?>> httpServletRequest(HttpServletRequest request) {
		Map<String, Map<String, ?>> response = new LinkedHashMap<>();
		response.put("parameters", request.getParameterMap());
		return response;
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
