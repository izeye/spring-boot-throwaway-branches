package com.izeye.throwaway;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} for {@link Person}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping(path = "/persons")
public class PersonController {

	// curl -v -XPOST -u "user:secret" -H "Accept: application/json" -H "Content-type: application/json" -d '{"firstName": "Johnny", "lastName": "Lim"}' "http://localhost:8080/persons"
	@PostMapping
	public Person post(@RequestBody Person person, HttpServletRequest request) {
		System.out.println("Headers:");
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			System.out.println(headerName + ": " + request.getHeader(headerName));
		}

		System.out.println("Request body:");
		System.out.println(person);
		return person;
	}

}
