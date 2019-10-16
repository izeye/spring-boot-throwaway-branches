package com.izeye.throwaway;

import java.time.Duration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/httpServletRequest")
	public String httpServletRequest(HttpServletRequest request) {
		return request.toString();
	}

	@GetMapping("/throwException")
	public String throwException() {
		throw new RuntimeException("Expected.");
	}

	@GetMapping("/echo")
	public String echo(@RequestParam String value) {
		return value;
	}

	@GetMapping("/responseEntity")
	public ResponseEntity<String> responseEntity() {
		return ResponseEntity.ok()
				.body("Hello, world!");
	}

	@GetMapping("/responseEntityCacheControlEmpty")
	public ResponseEntity<String> responseEntityCacheControlEmpty() {
		return ResponseEntity.ok()
				.cacheControl(CacheControl.empty())
				.body("Hello, world!");
	}

	@GetMapping("/responseEntityCacheControlNoStore")
	public ResponseEntity<String> responseEntityCacheControlNoStore() {
		return ResponseEntity.ok()
				.cacheControl(CacheControl.noStore())
				.body("Hello, world!");
	}

	@GetMapping("/responseEntityCacheControlMaxAge")
	public ResponseEntity<String> responseEntityCacheControlMaxAge() {
		return ResponseEntity.ok()
				.cacheControl(CacheControl.maxAge(Duration.ofMinutes(10)))
				.body("Hello, world!");
	}

}
