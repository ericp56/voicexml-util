package com.nextivr.vxml.browser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.StatusLine;

/**
 * A simple class to hold just what we need returned from an HTTP command.
 */
public class HttpResponse {

    String message;
    StatusLine statusLine;
    Map<String, Header> headerMap = new HashMap<>();

    private void processHeaders(Header[] headers) {
        headerMap.clear();
        if (null == headers) {
            return;
        }
        for (int i = 0; i < headers.length; i++) {
            headerMap.put(headers[i].getName(), headers[i]);
        }

    }

    public HttpResponse(String message, Header[] headers, StatusLine statusLine) {
        this.message = message;
        processHeaders(headers);
        this.statusLine = statusLine;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Header[] getHeaders() {
        List<Header> headers = new ArrayList<>();
        Iterator<Header> iter = headerMap.values().iterator();
        while (iter.hasNext()) {
            headers.add(iter.next());
        }
        return headers.toArray(new Header[headers.size()]);
    }

    public void setHeaders(Header[] headers) {
        processHeaders(headers);
    }

    public StatusLine getStatusLine() {
        return statusLine;
    }

    public void setStatusLine(StatusLine statusLine) {
        this.statusLine = statusLine;
    }

    public String getHeaderValue(String key) {
        if(headerMap.containsKey(key)) {
            return headerMap.get(key).getValue();
        } else {
            return "";
        }
    }

}
