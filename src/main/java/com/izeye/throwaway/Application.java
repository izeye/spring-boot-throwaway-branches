package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Main class.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
@ImportResource(locations = {
		"classpath:applicationContext.xml", "classpath:applicationContext2.xml"
})
public class Application implements CommandLineRunner {

	@Autowired
	private String string;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.string);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
