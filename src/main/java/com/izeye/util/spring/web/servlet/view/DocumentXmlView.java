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

package com.izeye.util.spring.web.servlet.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.View;

import org.w3c.dom.Document;

import com.izeye.util.XmlUtils;

/**
 * {@link View} for XML from {@link Document}.
 *
 * @author Johnny Lim
 */
public class DocumentXmlView implements View {

	private final Document document;

	public DocumentXmlView(Document document) {
		this.document = document;
	}

	@Override
	public String getContentType() {
		return MediaType.APPLICATION_XML_VALUE;
	}

	@Override
	public void render(
			Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType(getContentType());
		FileCopyUtils.copy(XmlUtils.document2Xml(document), response.getWriter());
	}

}
