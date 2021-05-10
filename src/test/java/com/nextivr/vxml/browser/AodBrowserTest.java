package com.nextivr.vxml.browser;

import com.nextivr.vxml.validator.VxmlValidator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
 public class AodBrowserTest extends TestCase {
    private static final String SRC = "src";
    private static final String VXML_AUDIO = "vxml:audio";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AodBrowserTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AodBrowserTest.class);
    }

    public void testBrowserAndValidator() throws Exception {
        AodBrowser browser = new AodBrowser();
        
        HttpResponse fetchDocument = browser.initApp("localhost", "8080", "Weatherline2", "");

        VxmlValidator validator = new VxmlValidator(fetchDocument.getMessage());

        validator = browser.start("919411234", "1234")
        .xpElementContainsText(VXML_AUDIO, "To test the rest API, press 1.")
        .xpElementAttrContainsText(VXML_AUDIO, SRC, "MainMenu.wav")
        .xpVerifyElementCount(VXML_AUDIO, 1);

        validator = browser.chooseMenuOption(validator, 1, "1", "1", "dtmf")
        .xpElementContainsText(VXML_AUDIO, "Please enter your zip code.")
        .xpElementAttrContainsText(VXML_AUDIO, SRC, "EnterZip.wav")
        .xpVerifyElementCount(VXML_AUDIO, 2);

        validator = browser.choosePromptCollect(validator, "12345", "12345", "dtmf")
        .xpElementContainsText(VXML_AUDIO, "Your forecast")
        .xpElementAttrContainsText(VXML_AUDIO, SRC, "Forecast2.wav")
        .xpVerifyElementCount(VXML_AUDIO, 3);


        validator = browser.getDefaultNext(validator)
        .xpElementContainsText(VXML_AUDIO, "To test the rest API, press 1.")
        .xpElementAttrContainsText(VXML_AUDIO, SRC, "MainMenu.wav")
        .xpVerifyElementCount(VXML_AUDIO, 1);

        validator = browser.error(validator)
        .xpVerifyElementCount("vxml:form[@id='end']", 1);

    }

    public void testCustomBrowsingAndValidator() throws Exception {
        AodBrowser browser = new AodBrowser();
        String urlBase = "http://localhost:8080/Weatherline2/";
        HttpResponse fetchDocument = browser.startApp(urlBase + "Start");

        VxmlValidator validator = new VxmlValidator(fetchDocument.getMessage());
        String next = validator.getDefaultSubmitUrl();

        browser.addField(AodInitialSettings.session___ani.toString(), "919411234");
        
        fetchDocument = browser.getNextPage(urlBase + next);
        String vxmlString = fetchDocument.getMessage();
        validator = new VxmlValidator(vxmlString);
        System.out.println(vxmlString);

        validator.xpElementContainsText(VXML_AUDIO, "To test the rest API, press 1.")
        .xpElementAttrContainsText(VXML_AUDIO, SRC, "MainMenu.wav")
        .xpVerifyElementCount(VXML_AUDIO, 1);

        String menuName = validator.findXPath("/vxml:vxml/vxml:menu/@id");

        browser.addField(menuName + "___Column0", "1");
        browser.addField(menuName + "___utterance", "1");
        browser.addField(menuName + "___interpretation", "1");
        browser.addField(menuName + "___value", "1");
        browser.addField(menuName + "___inputmode", "dtmf");
        browser.addField(menuName + "___confidence", "1");
        browser.addField(menuName + "___noinputcount", "0");
        browser.addField(menuName + "___nomatchcount", "0");
        
        next = validator.findXPath("/vxml:vxml/vxml:form[@id='choice0']/vxml:block/vxml:assign/@expr").replaceAll("'", "");

        fetchDocument = browser.getNextPage(urlBase + next);
        vxmlString = fetchDocument.getMessage();
        validator = new VxmlValidator(vxmlString);


        validator.xpElementContainsText(VXML_AUDIO, "Please enter your zip code.")
        .xpElementAttrContainsText(VXML_AUDIO, SRC, "EnterZip.wav")
        .xpVerifyElementCount(VXML_AUDIO, 2);

        String formName = validator.findXPath("/vxml:vxml/vxml:form/@id");

        browser.addField(formName + "___utterance", "12345");
        browser.addField(formName + "___interpretation", "12345");
        browser.addField(formName + "___value", "12345");
        browser.addField(formName + "___inputmode", "dtmf");
        browser.addField(formName + "___confidence", "1");
        browser.addField(formName + "___noinputcount", "0");
        browser.addField(formName + "___nomatchcount", "0");

        next = validator.findXPath("/vxml:vxml/vxml:form/vxml:block/vxml:submit/@next");

        fetchDocument = browser.getNextPage(urlBase + next);
        vxmlString = fetchDocument.getMessage();
        validator = new VxmlValidator(vxmlString);


        validator.xpElementContainsText(VXML_AUDIO, "Your forecast")
        .xpElementAttrContainsText(VXML_AUDIO, SRC, "Forecast2.wav")
        .xpVerifyElementCount(VXML_AUDIO, 3);


        next = validator.getDefaultSubmitUrl();

        fetchDocument = browser.getNextPage(urlBase + next);
        vxmlString = fetchDocument.getMessage();
        validator = new VxmlValidator(vxmlString);

        validator.xpElementContainsText(VXML_AUDIO, "To test the rest API, press 1.")
        .xpElementAttrContainsText(VXML_AUDIO, SRC, "MainMenu.wav")
        .xpVerifyElementCount(VXML_AUDIO, 1);

        next = validator.findXPath("/vxml:vxml/vxml:catch[@event='error']/vxml:goto/@next");
        fetchDocument = browser.getNextPage(urlBase + next);
        vxmlString = fetchDocument.getMessage();
        validator = new VxmlValidator(vxmlString);

        validator
        .xpVerifyElementCount("vxml:form[@id='end']", 1);

        System.out.println(formName);
        System.out.println(urlBase + next);
        System.out.println(vxmlString);
    }
}
