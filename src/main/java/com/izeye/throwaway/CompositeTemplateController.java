package com.izeye.throwaway;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * {@link Controller} for a composite template.
 *
 * @author Johnny Lim
 */
@Controller
@RequestMapping("/composite-template")
public class CompositeTemplateController {

	@GetMapping
	public String showCompositeTemplate(Model model) {
		model.addAttribute("sub_template1_name", "Sub-template 1");
		model.addAttribute("sub_template2_name", "Sub-template 2");
		return "composite_template";
	}

}
