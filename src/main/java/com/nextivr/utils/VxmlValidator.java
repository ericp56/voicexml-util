package com.nextivr.utils;

public class VxmlValidator {

    private XmlValidator xval;

    /**
     * 
     * @param vxmlString the document to evaluate
     */
    public VxmlValidator(String vxmlString) {
        XmlValidator xv = new XmlValidator(vxmlString);
        this.xval = xv;
    }

    /**
     * 
     * @param element element to look for e.g. "prompt" or "grammar"
     * @param text that should be contained e.g. "This is the main menu" or "operator"
     * @return this VxmlValidator, so you can chain together the validations.
     * @throws Exception if there is no element with the text
     */
    public VxmlValidator xpElementContainsText(String element, String text) throws Exception {
        String ret = xval.findXPath("//*[name()='" + element + "']//text()[contains(., '" + text + "')]");
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
        String ret = xval.findXPath("//*[name()='" + element + "' and contains(@" + attribute + ", '" + text + "')]");
        if (ret.length() == 0) {
            throw new Exception(element + "@" + attribute + " text not found: " + text);
        }
        return this;
    }

}
