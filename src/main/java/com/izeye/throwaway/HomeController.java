package com.izeye.throwaway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * {@link Controller} for the home page.
 *
 * @author Johnny Lim
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {

	@GetMapping
	public String home() {
		return "index";
	}

}
