package com.izeye.throwaway;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String home(Model model) {
		Map<String, Object> someMap = new HashMap<>();
		someMap.put("firstName", "Johnny");
		someMap.put("lastName", "Lim");
		someMap.put("age", 20);
		model.addAttribute("someMap", someMap);
		return "index";
	}

}
