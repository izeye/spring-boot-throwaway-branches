package com.izeye.throwaway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by izeye on 15. 9. 19..
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
//		new MBeanFactory();
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ok!");
		System.exit(0);
	}
	
}
