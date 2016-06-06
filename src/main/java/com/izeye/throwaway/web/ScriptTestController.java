package com.izeye.throwaway.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by izeye on 16. 4. 25..
 */
@Controller
public class ScriptTestController {
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/test/script")
	public String testScript(Model model) {
		model.addAttribute("url", "http://localhost:" + port + "/js/test.js");
		return "test_script";
	}
	
}
