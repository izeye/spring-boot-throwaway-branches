package com.izeye.throwaway.web;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("requestURL: " + requestURL);
		requestURL.append("?a=b");
		System.out.println("requestURL: " + requestURL);
		System.out.println("request.getRequestURL(): " + request.getRequestURL());
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

	@GetMapping("/map")
	public Map<String, Object> map() {
		return getPersonMap();
	}

	private Map<String, Object> getPersonMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("firstName", "Johnny");
		map.put("lastName", "Lim");
		map.put("age", 20);
		return map;
	}

	@GetMapping("/modelAndView")
	public ModelAndView modelAndView() {
		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("person", getPersonMap());
		return modelAndView;
	}

	@GetMapping("/responseEntity")
	public ResponseEntity<Map<String, Object>> responseEntity() {
		return ResponseEntity.ok()
				.body(getPersonMap());
	}

	@GetMapping("/responseEntityCacheControlEmpty")
	public ResponseEntity<Map<String, Object>> responseEntityCacheControlEmpty() {
		return ResponseEntity.ok()
				.cacheControl(CacheControl.empty())
				.body(getPersonMap());
	}

	@GetMapping("/responseEntityCacheControlNoStore")
	public ResponseEntity<Map<String, Object>> responseEntityCacheControlNoStore() {
		return ResponseEntity.ok()
				.cacheControl(CacheControl.noStore())
				.body(getPersonMap());
	}

	@GetMapping("/responseEntityCacheControlMaxAge")
	public ResponseEntity<Map<String, Object>> responseEntityCacheControlMaxAge() {
		return ResponseEntity.ok()
				.cacheControl(CacheControl.maxAge(Duration.ofMinutes(10)))
				.body(getPersonMap());
	}

}
