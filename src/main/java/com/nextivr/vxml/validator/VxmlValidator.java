package com.nextivr.vxml.validator;

public class VxmlValidator extends XmlValidator{

    public VxmlValidator(String xmlString) {
        super(xmlString);
        this.addXpathNamespace("vxml", "http://www.w3.org/2001/vxml");
    }

    /**
     * 
     * @param element element to look for e.g. "prompt" or "grammar"
     * @param text that should be contained e.g. "This is the main menu" or "operator"
     * @return this VxmlValidator, so you can chain together the validations.
     * @throws Exception if there is no element with the text
     */
    public VxmlValidator xpElementContainsText(String element, String text) throws Exception {
        String ret = findXPath("//" + element + "//text()[contains(., '" + text + "')]");
        if (ret.length() == 0) {
            throw new Exception(element + " text not found: " + text);
        }
        return this;
    }

    /**
     * 
     * @param element element to look for e.g. "audio"
     * @param attribute attribute to look for e.g. "src"
     * @param text that should be contained e.g. "please_hold.wav"
     * @return this VxmlValidator, so you can chain together the validations.
     * @throws Exception if there is no element with the text
     */
    public VxmlValidator xpElementAttrContainsText(String element, String attribute, String text) throws Exception {
        String ret = findXPath("//" + element + "[contains(@" + attribute + ", '" + text + "')]");
        if (ret.length() == 0) {
            throw new Exception(element + "@" + attribute + " text not found: " + text);
        }
        return this;
    }
 
    /**
     * get the xpath /vxml/form/block/submit/@next
     * @return
     * @throws Exception
     */
    public String getDefaultSubmitUrl() throws Exception {
        String ret = findXPath("/vxml:vxml/vxml:form/vxml:block/vxml:submit/@next");
        return ret;
    }

    public VxmlValidator xpVerifyElementCount(String element,int count) throws Exception {
        String ret = findXPath("count(//" + element + ")");
        if (!ret.equals(String.valueOf(count))) {
            throw new Exception(element + " count expected " + count + " actual " + ret);
        }
        return this;
    }


}