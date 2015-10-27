package com.izeye.throwaway;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by izeye on 15. 10. 27..
 */
@RestController
@RequestMapping(path = "/**")
@Profile("!docs")
public class MasterController {
	
	@RequestMapping
	public String doAll() {
		return "Do all!";
	}
	
}
