package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.izeye.throwaway.config.LoadAdditionalProperties;
import com.izeye.throwaway.repository.BucketTestRepository;

/**
 * Main class.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private BucketTestRepository bucketTestRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.bucketTestRepository);
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
				.listeners(new LoadAdditionalProperties())
				.run(args);
	}

}
