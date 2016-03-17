package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Arrays;

/**
 * Created by izeye on 15. 9. 19..
 */
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Application implements CommandLineRunner {
	
	@Value("${app.some-property}")
	private String appSomeProperty;
	
	@Autowired
	private AppProperties appProperties;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("args: " + Arrays.asList(args));
		System.out.println("appSomeProperty: " + appSomeProperty);
		System.out.println("APP_SOME_PROPERTY: " + System.getProperty("APP_SOME_PROPERTY"));
		System.out.println("appProperties.getSomeProperty(): " + appProperties.getSomeProperty());
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
