package com.izeye.throwaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("System.console(): " + System.console());

		SpringApplication.run(Application.class, args);
	}
	
}
