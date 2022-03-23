package com.izeye.throwaway.web;

import com.izeye.throwaway.util.XmlUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

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
