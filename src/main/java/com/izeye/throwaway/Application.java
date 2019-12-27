package com.izeye.throwaway;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.izeye.throwaway.service.PersonService;

/**
 * Application.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
public class Application {

	private final PersonService personService;

	public Application(PersonService personService) {
		this.personService = personService;
	}

	@PreDestroy
	public void preDestroy() {
		String message = this.personService.getMessage();
		System.out.println(message);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
