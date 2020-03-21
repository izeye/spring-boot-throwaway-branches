package com.izeye.throwaway;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.izeye.throwaway.config.scan.ScanConfig;
import com.izeye.throwaway.domain.Person;

/**
 * Main class.
 *
 * @author Johnny Lim
 */
//@SpringBootApplication
@SpringBootApplication(scanBasePackageClasses = ScanConfig.class)
public class Application implements ApplicationContextAware, CommandLineRunner {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void run(String... args) {
		System.out.println(this.applicationContext.getBeansOfType(Person.class));
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
