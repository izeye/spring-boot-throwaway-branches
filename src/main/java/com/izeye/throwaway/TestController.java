package com.izeye.throwaway;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.Map;

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
	
	@RequestMapping(path = "/redirect_to_test", method = RequestMethod.GET)
	public String redirectToTest() {
		return "redirect:/test";
	}

	@RequestMapping(path = "/redirect_to_does_not_exist", method = RequestMethod.GET)
	public String redirectToDoesNotExist() {
		return "redirect:/{doesNotExist}";
	}

	@RequestMapping(path = "/redirect_to_does_not_exist_with_custom_redirect_view",
			method = RequestMethod.GET)
	public RedirectView redirectToDoesNotExistWithCustomRedirectView() {
		RedirectView redirectView = new RedirectView("{doesNotExist}");
		redirectView.setExpandUriTemplateVariables(false);
		return redirectView;
	}
	
	@GetMapping("/error")
	public void error() {
		throw new RuntimeException("Expected error.");
	}

	@GetMapping("/test-null-field")
	public String testNullField(Model model) {
		model.addAttribute("person", new Person());
		return "test_null_field";
	}

	@GetMapping("/null-model-and-view")
	public ModelAndView testNullModelAndView() {
		return null;
	}

	@GetMapping("/test-switch")
	public String testSwitch(Model model) {
		model.addAttribute("firstName", null);
		model.addAttribute("lastName", "null");
		return "test_switch";
	}

	@GetMapping("/test-missing-field")
	public ModelAndView testMissingField() {
		Person person = new Person();
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(20);
		Map<String, Object> model = Collections.singletonMap("person", person);
		return new ModelAndView("test_missing_field", model);
	}

	@GetMapping("/test-reference-bean")
	public ModelAndView testReferenceBean() {
		return new ModelAndView("test_reference_bean");
	}
	
}
