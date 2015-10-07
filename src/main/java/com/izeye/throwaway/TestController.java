package com.izeye.throwaway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by izeye on 15. 10. 7..
 */
@Controller
@RequestMapping(path = "/test")
public class TestController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "test";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String post(@RequestParam String name) {
		return name;
	}
	
}
