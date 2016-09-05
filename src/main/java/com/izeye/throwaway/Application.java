package com.izeye.throwaway;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.izeye.throwaway.service.PersonService;

/**
 * Created by izeye on 15. 9. 19..
 */
@SpringBootApplication
public class Application {

	@Autowired
	private PersonService personService;

	@PreDestroy
	public void preDestroy() {
		String message = this.personService.getMessage();
		System.out.println(message);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
