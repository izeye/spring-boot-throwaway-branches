package com.izeye.throwaway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by izeye on 15. 9. 19..
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("In run:");
		ClassLoader classLoader = Application.class.getClassLoader();
		while (classLoader != null) {
			System.out.println(classLoader);
			classLoader = classLoader.getParent();
		}
	}

	public static void main(String[] args) {
		System.out.println("In main:");
		ClassLoader classLoader = Application.class.getClassLoader();
		while (classLoader != null) {
			System.out.println(classLoader);
			classLoader = classLoader.getParent();
		}
		
		SpringApplication.run(Application.class, args);
	}
	
}
