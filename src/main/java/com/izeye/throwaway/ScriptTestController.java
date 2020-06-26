package com.izeye.throwaway;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * {@link Controller} for testing scripts.
 *
 * @author Johnny Lim
 */
@Controller
public class ScriptTestController {
	
	@GetMapping("/test/script")
	public String testScript(Model model) {
		model.addAttribute("url", "/js/test.js");
		return "test_script";
	}
	
}
