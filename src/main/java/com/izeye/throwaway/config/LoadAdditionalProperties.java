package com.izeye.throwaway.config;

import java.io.IOException;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * {@link ApplicationListener} for loading additional properties.
 *
 * @author Johnny Lim
 */
public class LoadAdditionalProperties
		implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	private final ResourceLoader loader = new DefaultResourceLoader();

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		try {
			Resource resource = this.loader.getResource("classpath:/repository/bucket/bucket.yml");
			PropertySource<?> propertySource = new PropertySourcesLoader().load(resource);
			event.getEnvironment().getPropertySources().addLast(propertySource);
		}
		catch (IOException ex) {
			throw new IllegalStateException(ex);
		}
	}

}
