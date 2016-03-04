package com.izeye.throwaway;

import com.izeye.throwaway.domain.Person;
import com.izeye.throwaway.repository.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Created by izeye on 15. 9. 19..
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PersonMapper personMapper;

	@Override
	public void run(String... args) throws Exception {
		List<Person> persons = personMapper.findAll();
		System.out.println(persons);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
