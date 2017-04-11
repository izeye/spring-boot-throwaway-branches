package com.izeye.throwaway.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import com.izeye.throwaway.domain.Person;

/**
 * Configuration having {@link Scheduled}.
 *
 * @author Johnny Lim
 */
@Configuration
public class ScheduledInConfig {

	@Bean
	public Person person() {
		Person person = new Person();
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		return person;
	}

	// Just to test if registering a bean and autowiring it
	// in the same configuration work.
	@Autowired
	private Person person;

	@Scheduled(cron = "* * * * * ?")
	public void doScheduledJob() {
		System.out.println(new Date() + ": " + this.person);
	}

}
