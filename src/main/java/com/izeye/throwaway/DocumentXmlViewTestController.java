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
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.w3c.dom.Document;

import com.izeye.util.XmlUtils;
import com.izeye.util.spring.web.servlet.view.DocumentXmlView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
        String xml = createXml();
		Document document = XmlUtils.xml2Document(xml);
		return new ModelAndView(new DocumentXmlView(document));
	}

    private String createXml() {
        try {
            String resourceLocation = "classpath:test/persons.xml";
            File file = ResourceUtils.getFile(resourceLocation);
            return FileCopyUtils.copyToString(new FileReader(file));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
