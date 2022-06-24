package com.izeye.throwaway.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Test {@link RestController}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestRestController {

	@GetMapping("/request-header")
	public String requestHeader(@RequestHeader(name = "X-Test", required = false) String test) {
		log.info("test: {}", test);
		return test;
	}

	@GetMapping("/sleep")
	public String sleep(@RequestParam int milliseconds) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(milliseconds);
		return "Slept for " + milliseconds + " ms.";
	}

	@GetMapping("/request-parameter")
	public String requestParameter(@RequestParam String name) {
		return "Your name is " + name + ".";
	}

	@GetMapping("/request-parameters")
	public String requestParameters(@RequestParam String p1, @RequestParam String p2) {
		return "p1: " + p1 + ", p2: " + p2;
	}

	@GetMapping("/request-parameter-without-annotation")
	public String requestParameterWithoutAnnotation(String name) {
		return "Your name is " + name + ".";
	}

	@GetMapping("/print-all-headers")
	public Map<String, String> printAllHeaders(HttpServletRequest request) {
		return getAllHttpHeaders(request);
	}

	@GetMapping("/print-all-cookies")
	public Map<String, String> printAllCookies(HttpServletRequest request) {
		Map<String, String> map = new LinkedHashMap<>();
		for (Cookie cookie : request.getCookies()) {
			map.put(cookie.getName(), cookie.getValue());
		}
		return map;
	}

	private Map<String, String> getAllHttpHeaders(HttpServletRequest request) {
		Map<String, String> headers = new HashMap<>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			headers.put(name, request.getHeader(name));
		}
		return headers;
	}

}
