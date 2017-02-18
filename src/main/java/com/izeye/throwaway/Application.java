package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.izeye.throwaway.repository.BucketTestRepository;

/**
 * Main class.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	static {
		System.setProperty("spring.config.location", "classpath:/repository/bucket/bucket.yml");
	}

	@Autowired
	private BucketTestRepository bucketTestRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.bucketTestRepository);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
