package com.izeye.throwaway;

import com.izeye.throwaway.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

/**
 * Created by izeye on 15. 9. 19..
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {
//		List<Person> persons = personRepository.findAll();
//		System.out.println(persons);
		TimeUnit.SECONDS.sleep(50);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
