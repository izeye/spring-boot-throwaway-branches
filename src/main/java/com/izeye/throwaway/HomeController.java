package com.izeye.throwaway;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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

	@Autowired
	private XmlMapper xmlMapper;

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

	@GetMapping(path = "/map", headers = "Accept=application/xml")
	public String mapXml() {
		try {
			return this.xmlMapper.writer()
					.withRootName("root")
					.writeValueAsString(getPersonMap());
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

}
