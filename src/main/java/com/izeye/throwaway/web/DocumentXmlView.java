package com.izeye.throwaway.web;

import com.izeye.throwaway.util.XmlUtils;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.View;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
