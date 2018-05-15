package com.izeye.throwaway;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * {@link Controller} for Thymeleaf tests.
 *
 * @author Johnny Lim
 */
@Controller
@RequestMapping(path = "/thymeleaf")
public class ThymeleafController {

	private final TemplateEngine engine;

	public ThymeleafController() {
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".html");

		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(resolver);
		engine.setDialect(new SpringStandardDialect());

		this.engine = engine;
	}

	@GetMapping(path = "/sample", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String sample() {
		Map<String, Object> someMap = new HashMap<>();
		someMap.put("firstName", "Johnny");
		someMap.put("lastName", "Lim");
		someMap.put("age", 20);

		Context context = new Context();
		context.setVariable("someMap", someMap);
		return this.engine.process("index", context);
	}

}
