package com.izeye.throwaway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by izeye on 15. 12. 14..
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
	
}
