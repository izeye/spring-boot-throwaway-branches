package com.izeye.throwaway.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by izeye on 16. 6. 6..
 */
@Controller
@RequestMapping(path = "/test/security")
public class SecurityTestController {
	
	@GetMapping("/sign_out")
	public String signOut() {
		return "sign_out";
	}
	
}
