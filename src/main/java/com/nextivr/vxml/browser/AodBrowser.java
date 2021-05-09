package com.nextivr.vxml.browser;

import com.nextivr.vxml.validator.VxmlValidator;

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

    public HttpResponse initApp(String hostname, String port, String appName, String querystring) throws Exception {
        urlBase = String.format("http://%s:%s/%s/", hostname, port);
        HttpResponse fetchDocument = startApp(String.format("%s%s?%s", urlBase, appName, querystring));
        return fetchDocument;
    }

    public VxmlValidator start(String ani, String dnis) throws Exception {
        VxmlValidator validator = new VxmlValidator(fetchDocument.getMessage());
        String next = validator.getDefaultSubmitUrl();
        addField(AodInitialSettings.session___ani.toString(), ani);
        addField(AodInitialSettings.session___dnis.toString(), dnis);
        validator = getNextValidator(next);
        return validator;
    }

    public VxmlValidator chooseMenuOption(VxmlValidator validator, String value, String interpretation,
            String inputMode) throws Exception {
        String menuName = validator.findXPath("/vxml:vxml/vxml:menu/@id");

        addField(menuName + "___Column0", interpretation);
        addField(menuName + "___utterance", value);
        addField(menuName + "___interpretation", interpretation);
        addField(menuName + "___value", value);
        addField(menuName + "___inputmode", inputMode);
        addField(menuName + "___confidence", "1");
        addField(menuName + "___noinputcount", "0");
        addField(menuName + "___nomatchcount", "0");

        String next = validator.findXPath("/vxml:vxml/vxml:form[@id='choice0']/vxml:block/vxml:assign/@expr")
                .replaceAll("'", "");

        validator = getNextValidator(next);
        return validator;
    }

    private VxmlValidator getNextValidator(String next) throws Exception {
        VxmlValidator validator;
        fetchDocument = getNextPage(urlBase + next);
        String vxmlString = fetchDocument.getMessage();
        validator = new VxmlValidator(vxmlString);
        return validator;
    }

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

    public VxmlValidator getDefaultNext(VxmlValidator validator) throws Exception {
        String next = validator.getDefaultSubmitUrl();
        validator = getNextValidator(next);
        return validator;
    }

}
