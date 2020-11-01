package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Value("${favorite-fruit}")
	private String favoriteFruit;

	@Override
	public void run(String... args) {
		System.out.println(this.favoriteFruit);
	}

	public static void main(String[] args) {
		String fileEncoding = System.getProperty("file.encoding");
		System.out.println("file.encoding: " + fileEncoding);

		SpringApplication.run(Application.class, args);
	}

}
