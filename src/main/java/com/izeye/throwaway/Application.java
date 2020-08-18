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
		String fileEncoding = System.getProperty("file.encoding");
		System.out.println("file.encoding: " + fileEncoding);

		SpringApplication.run(Application.class, args);
	}
	
}
