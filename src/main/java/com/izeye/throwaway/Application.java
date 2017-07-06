package com.izeye.throwaway;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
public class Application {

	@PostConstruct
	public void init() {
		throw new SomeException("Something");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
