package com.izeye.throwaway;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

/**
 * Main class.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
@Slf4j
public class Application {

	@Bean
	ApplicationRunner applicationRunner() {
		return (args) -> {
			for (int i = 0; i < 100_000; i++) {
				log.info("Hello, world!");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
