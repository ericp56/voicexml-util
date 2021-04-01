package com.nextivr.utils;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class XmlValidator {

    private String xmlString;
    private XPath xpathObj = XPathFactory.newInstance().newXPath();

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
        return xpathObj.evaluate(xpath, xml);
    }

}
