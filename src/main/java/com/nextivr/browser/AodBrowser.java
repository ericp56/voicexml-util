package com.nextivr.browser;

import com.nextivr.model.HttpResponse;

public class AodBrowser extends VxmlBrowser{

    private HttpResponse fetchDocument;

    public HttpResponse startApp(String urlPathToStart) throws Exception {
        fetchDocument = this.fetchDocument(urlPathToStart);
        return fetchDocument;
    }

    public HttpResponse getNextPage(String urlPathToPage) throws Exception {
        fetchDocument = this.postDocument(urlPathToPage);
        return fetchDocument;
    }

    
}
