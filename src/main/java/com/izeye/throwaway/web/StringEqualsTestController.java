package com.izeye.throwaway.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by izeye on 16. 1. 25..
 */
@Controller
@RequestMapping(path = "/test/string/equals")
public class StringEqualsTestController {
	
	@RequestMapping
	public String testStringEquals(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "test_string_equals";
	}
	
}
