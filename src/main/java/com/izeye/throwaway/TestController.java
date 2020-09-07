package com.izeye.throwaway;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * {@link Controller} for testing.
 *
 * @author Johnny Lim
 */
@Controller
@RequestMapping(path = "/test")
public class TestController {

	@GetMapping("/redirect/parameter")
	public String redirectForTestingParameters() {
		return "redirect:/httpServletRequest?name=테스트";
	}

	@GetMapping("/redirect/fragment")
	public String redirectForTestingFragment() {
		return "redirect:/test_fragment.html#test";
	}

	@GetMapping("/redirect/fragment_unencoded")
	public String redirectForTestingUnencodedFragment() {
		return "redirect:/test_fragment.html#테스트";
	}

	@GetMapping("/redirect/fragment_encoded")
	public String redirectForTestingEncodedFragment() throws UnsupportedEncodingException {
		return "redirect:/test_fragment.html#" + URLEncoder.encode("테스트", "UTF-8");
	}

	@GetMapping("/redirect/path")
	public String redirectForTestingPath() {
		return "redirect:/test/테스트";
	}

	@GetMapping("/path/{value}")
	@ResponseBody
	public String path(@PathVariable String value) {
		System.out.println("value: " + value);
		return "value: " + value;
	}

}
