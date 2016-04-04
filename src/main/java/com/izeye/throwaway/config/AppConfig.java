package com.izeye.throwaway.config;

import com.izeye.throwaway.service.DefaultPersonServiceConsumer;
import com.izeye.throwaway.service.PersonServiceConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by izeye on 16. 4. 4..
 */
@Configuration
public class AppConfig {
	
	@Bean
	public PersonServiceConsumer personServiceConsumer() {
		return new DefaultPersonServiceConsumer();
	}
	
}
