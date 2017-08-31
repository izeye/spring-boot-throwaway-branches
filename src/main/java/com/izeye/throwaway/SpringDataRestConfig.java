package com.izeye.throwaway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Configuration for Spring Data REST.
 *
 * @author Johnny Lim
 */
@Configuration
public class SpringDataRestConfig {
	
	@Bean
	public ResourceProcessor<RepositoryLinksResource> repositoryLinksResourceProcessor() {
		return new ResourceProcessor<RepositoryLinksResource>() {
			@Override
			public RepositoryLinksResource process(RepositoryLinksResource resource) {
				Link fruitsLink = linkTo(methodOn(FruitResourceController.class).fruitsWithResources())
						.withRel("fruits");
				resource.add(fruitsLink);
				return resource;
			}
		};
	}

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.getCorsRegistry().addMapping("/persons/**");
			}
		};
	}
	
}
