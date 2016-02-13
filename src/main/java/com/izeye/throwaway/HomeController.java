package com.izeye.throwaway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by izeye on 16. 2. 13..
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String index() {
		return "Hello, world!";
	}
	
}
