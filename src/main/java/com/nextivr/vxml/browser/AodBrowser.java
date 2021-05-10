package com.nextivr.vxml.browser;

import com.nextivr.vxml.validator.VxmlValidator;

/**
 * Extension of the {@link VxmlBrowser} for Avaya OD applications.
 */
public class AodBrowser extends VxmlBrowser {

    private HttpResponse fetchDocument;
    private String urlBase;

    public String getUrlBase() {
        return urlBase;
    }

    public HttpResponse startApp(String urlPathToStart) throws Exception {
        fetchDocument = this.fetchDocument(urlPathToStart);
        return fetchDocument;
    }

    public HttpResponse getNextPage(String urlPathToPage) throws Exception {
        fetchDocument = this.postDocument(urlPathToPage);
        return fetchDocument;
    }

    /**
     * Run this first, to start the AOD session
     * @param hostname
     * @param port
     * @param appName
     * @param querystring
     * @return
     * @throws Exception
     */
    public HttpResponse initApp(String hostname, String port, String appName, String querystring) throws Exception {
        urlBase = String.format("http://%s:%s/%s/", hostname, port, appName);
        HttpResponse fetchDocument = startApp(String.format("%sStart?%s", urlBase, querystring));
        return fetchDocument;
    }

    /**
     * Run this second, to start the app.
     * @param ani
     * @param dnis
     * @return
     * @throws Exception
     */
    public VxmlValidator start(String ani, String dnis) throws Exception {
        VxmlValidator validator = new VxmlValidator(fetchDocument.getMessage());
        String next = validator.getDefaultSubmitUrl();
        addField(AodInitialSettings.session___ani.toString(), ani);
        addField(AodInitialSettings.session___dnis.toString(), dnis);
        validator = getNextValidator(next);
        return validator;
    }

    /**
     * 
     * @param validator the {@link VxmlValidator} from the previous step
     * @param optionNumber this position of the menu option 
     * @param value value of the grammar item selected for the menu option e.g. 2
     * @param interpretation the raw value of the menu option e.g. billing, two, 2, etc.
     * @param inputMode dtmf or voice
     * @return
     * @throws Exception
     */
    public VxmlValidator chooseMenuOption(VxmlValidator validator, int optionNumber, String value,
            String interpretation, String inputMode) throws Exception {
        String menuName = validator.findXPath("/vxml:vxml/vxml:menu/@id");

        addField(menuName + "___Column0", value);
        addField(menuName + "___utterance", interpretation);
        addField(menuName + "___interpretation", value);
        addField(menuName + "___value", value);
        addField(menuName + "___inputmode", inputMode);
        addField(menuName + "___confidence", "1");
        addField(menuName + "___noinputcount", "0");
        addField(menuName + "___nomatchcount", "0");

        String xpath = String.format("/vxml:vxml/vxml:form[@id='choice%s']/vxml:block/vxml:assign/@expr",
                optionNumber - 1);
        String next = validator.findXPath(xpath).replaceAll("'", "");

        validator = getNextValidator(next);
        return validator;
    }

    /**
     * Load the next page
     * @param next the servlet to load 
     * @return {@link VxmlValidator} 
     * @throws Exception
     */
    private VxmlValidator getNextValidator(String next) throws Exception {
        VxmlValidator validator;
        fetchDocument = getNextPage(urlBase + next);
        String vxmlString = fetchDocument.getMessage();
        validator = new VxmlValidator(vxmlString);
        return validator;
    }

    /**
     * load the next page based on the /vxml/catch[@event='error']/goto/@next
     * @param validator
     * @return
     * @throws Exception
     */
    public VxmlValidator error(VxmlValidator validator) throws Exception {
        String next = validator.findXPath("/vxml:vxml/vxml:catch[@event='error']/vxml:goto/@next");
        validator = getNextValidator(next);
        return validator;
    }

    /**
     * get the next servlet via the {@link VxmlValidator}.getDefaultSubmitUrl()
     * @param validator
     * @return
     * @throws Exception
     */
    public VxmlValidator getDefaultNext(VxmlValidator validator) throws Exception {
        String next = validator.getDefaultSubmitUrl();
        validator = getNextValidator(next);
        return validator;
    }

    /**
     * 
     * @param validator the {@link VxmlValidator} from the previous step
     * @param value value of the grammar item entered e.g. 2
     * @param interpretation the raw value of item entered e.g. two
     * @param inputMode dtmf or voice
     * @return
     * @throws Exception
     */
    public VxmlValidator choosePromptCollect(VxmlValidator validator, String value, String interpretation,
            String inputMode) throws Exception {
        String formName = validator.findXPath("/vxml:vxml/vxml:form/@id");

        addField(formName + "___utterance", value);
        addField(formName + "___interpretation", interpretation);
        addField(formName + "___value", value);
        addField(formName + "___inputmode", inputMode);
        addField(formName + "___confidence", "1");
        addField(formName + "___noinputcount", "0");
        addField(formName + "___nomatchcount", "0");

        String next = validator.findXPath("/vxml:vxml/vxml:form/vxml:block/vxml:submit/@next");

        validator = getNextValidator(next);
        return validator;
    }
}