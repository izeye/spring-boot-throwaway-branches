package com.izeye.throwaway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by izeye on 16. 1. 5..
 */
@RestController
@RequestMapping(path = "/rest-proxy")
public class RestProxyController {
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public String proxy(@RequestParam String url) {
		return restTemplate.getForObject(url, String.class);
	}
	
}
