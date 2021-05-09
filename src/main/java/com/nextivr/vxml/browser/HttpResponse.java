package com.nextivr.vxml.browser;
import java.util.Arrays;

import org.apache.http.Header;
import org.apache.http.StatusLine;

/**
 * A simple class to hold just what we need returned from an HTTP command.
 */
public class HttpResponse {

    String message;
    Header[] headers;
    StatusLine statusLine;

    @Override
    public String toString() {
        return "HttpResponse [headers=" + Arrays.toString(headers) + ", message=" + message + ", statusLine="
                + statusLine + "]";
    }
    public HttpResponse(String message, Header[] headers, StatusLine statusLine) {
        this.message = message;
        this.headers = headers;
        this.statusLine = statusLine;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Header[] getHeaders() {
        return headers;
    }
    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }
    public StatusLine getStatusLine() {
        return statusLine;
    }
    public void setStatusLine(StatusLine statusLine) {
        this.statusLine = statusLine;
    }
    
    
}
