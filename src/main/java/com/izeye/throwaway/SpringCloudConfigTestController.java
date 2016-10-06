package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by izeye on 16. 6. 22..
 */
@RestController
@RequestMapping(path = "/test/spring-cloud-config")
@RefreshScope
public class SpringCloudConfigTestController {
	
	@Value("${my.name}")
	private String myName;
	
	@GetMapping("/my-name")
	public String myName() {
		return myName;
	}
	
}
