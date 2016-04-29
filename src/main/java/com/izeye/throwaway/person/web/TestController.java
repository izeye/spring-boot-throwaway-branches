package com.izeye.throwaway.person.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by izeye on 16. 4. 29..
 */
@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/httpServletRequest")
	public Map<String, String> testHttpServletRequest(HttpServletRequest request) {
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		String queryString = request.getQueryString();
		
		Map<String, String> response = new HashMap<>();
		response.put("requestURL", requestURL.toString());
		response.put("requestURI", requestURI);
		response.put("queryString", queryString);
		return response;
	}
	
}
