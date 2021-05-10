package com.nextivr.vxml.validator;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class XmlValidator {

    private String xmlString;
    private XPath xpathObj = XPathFactory.newInstance().newXPath();
    private Map<String, String> prefMap = new HashMap<>();

    /**
     * 
     * @param xmlString of xml document to evaluate with this object instance
     */
    public XmlValidator(String xmlString) {
        this.xmlString = xmlString;
    }

    /**
     * 
     * @param xpath the xpath command that will return a String
     * @return the string returned for the matching xpath parameter
     * @throws XPathExpressionException
     */
    public String findXPath(String xpath) throws XPathExpressionException {
        InputSource xml = new InputSource(new StringReader(xmlString));

        SimpleNamespaceContext namespaces = new SimpleNamespaceContext(prefMap);
        xpathObj.setNamespaceContext(namespaces);

        return xpathObj.evaluate(xpath, xml);
    }

    /**
     * use this method to add namespace contexts before calling {@link findXPath}
     * @param prefix
     * @param uri
     */
    public void addXpathNamespace(String prefix, String uri) {
        prefMap.put(prefix, uri);

    }


}
