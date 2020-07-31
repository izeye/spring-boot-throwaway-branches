package com.izeye.throwaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.setWebApplicationType(WebApplicationType.REACTIVE);
		application.run(args);
	}
	
}
