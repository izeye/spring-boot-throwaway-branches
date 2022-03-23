package com.izeye.throwaway.util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

/**
 * Utilities for XML.
 *
 * @author Johnny Lim
 */
public final class XmlUtils {

    private static final String DEFAULT_CHARSET = "UTF-8";

    private static final ThreadLocal<DocumentBuilderFactory> DOCUMENT_BUILDER_FACTORY =
            ThreadLocal.withInitial(() -> DocumentBuilderFactory.newInstance());

    private static final ThreadLocal<TransformerFactory> TRANSFORMER_FACTORY =
            ThreadLocal.withInitial(() -> TransformerFactory.newInstance());

    private XmlUtils() {
    }

    public static Document xml2Document(String xml) {
        try {
            DocumentBuilder builder = DOCUMENT_BUILDER_FACTORY.get().newDocumentBuilder();
            return builder.parse(new ByteArrayInputStream(xml.getBytes(DEFAULT_CHARSET)));
        }
        catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        }
        catch (SAXException ex) {
            throw new RuntimeException(ex);
        }
        catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String document2Xml(Document document) {
        try {
            Transformer transformer = TRANSFORMER_FACTORY.get().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            return writer.toString();
        }
        catch (TransformerConfigurationException ex) {
            throw new RuntimeException(ex);
        }
        catch (TransformerException ex) {
            throw new RuntimeException(ex);
        }
    }

}
