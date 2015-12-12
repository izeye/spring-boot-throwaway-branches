package com.izeye.throwaway;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by izeye on 15. 12. 12..
 */
@RestController
@RequestMapping(path = "/fruits")
public class FruitResourceController {

	// NOTE: The `produces` attribute is only for browsers.
	@RequestMapping(method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
	public Resource<Fruit[]> fruits() {
		Resource<Fruit[]> resource = new Resource<Fruit[]>(Fruit.values());
		resource.add(linkTo(methodOn(FruitResourceController.class).fruits()).withSelfRel());
		return resource;
	}

	@RequestMapping(path = "/without-resource", method = RequestMethod.GET)
	public Fruit[] fruitsWithoutResource() {
		return Fruit.values();
	}
	
}
