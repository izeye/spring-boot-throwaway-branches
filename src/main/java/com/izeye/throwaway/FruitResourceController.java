package com.izeye.throwaway;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by izeye on 15. 12. 14..
 */
@RestController
@RequestMapping(path = "/fruits")
public class FruitResourceController {

	@RequestMapping(method = RequestMethod.GET)
	public Fruit[] fruits() {
		return Fruit.values();
	}

	// NOTE: The `produces` attribute is only for browsers.
	@RequestMapping(path = "/with-resource", method = RequestMethod.GET,
			produces = MediaTypes.HAL_JSON_VALUE)
	public Resource<Fruit[]> fruitsWithResource() {
		Resource<Fruit[]> resource = new Resource<Fruit[]>(Fruit.values());
		Link selfLink = linkTo(methodOn(FruitResourceController.class).fruitsWithResource())
				.withSelfRel();
		resource.add(selfLink);
		return resource;
	}

	// NOTE: The `produces` attribute is only for browsers.
	@RequestMapping(path = "/with-resources", method = RequestMethod.GET,
			produces = MediaTypes.HAL_JSON_VALUE)
	public Resources<Fruit> fruitsWithResources() {
		Resources<Fruit> resources = new Resources<Fruit>(Arrays.asList(Fruit.values()));
		Link selfLink = linkTo(methodOn(FruitResourceController.class).fruitsWithResources())
				.withSelfRel();
		resources.add(selfLink);
		return resources;
	}

}
