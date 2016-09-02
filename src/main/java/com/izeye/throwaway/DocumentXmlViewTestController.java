/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.izeye.throwaway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.w3c.dom.Document;

import com.izeye.util.XmlUtils;
import com.izeye.util.spring.web.servlet.view.DocumentXmlView;

/**
 * {@link Controller} for testing {@link DocumentXmlView}.
 *
 * @author Johnny Lim
 */
@Controller
@RequestMapping(path = "/test/xml")
public class DocumentXmlViewTestController {

	@GetMapping("/persons")
	public ModelAndView persons() {
		String xml = "<persons><person><id>1</id><personName><firstName>Johnny</firstName><lastName>Lim</lastName></personName><age>20</age></person></persons>";
		Document document = XmlUtils.xml2Document(xml);
		return new ModelAndView(new DocumentXmlView(document));
	}

}
