package com.izeye.throwaway.config;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.izeye.throwaway.repository.YamlBucketTestRepository;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;

/**
 * Configuration for {@link com.izeye.throwaway.domain.BucketTest}.
 *
 * @author Johnny Lim
 */
@Configuration
public class BucketTestConfig {

	private static final String RESOURCE_PATH = "repository/bucket/bucket.yml";

	private final Yaml yaml = new Yaml(new CustomClassLoaderConstructor(
			YamlBucketTestRepository.class, YamlBucketTestRepository.class.getClassLoader()));

	@Bean
	public YamlBucketTestRepository bucketTestRepository() {
		return load(RESOURCE_PATH);
	}

	private YamlBucketTestRepository load(String resourcePath) {
		return (YamlBucketTestRepository) this.yaml.load(asInputStream(resourcePath));
	}

	private InputStream asInputStream(String resourcePath) {
		try {
			return new ClassPathResource(resourcePath).getInputStream();
		}
		catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

}
