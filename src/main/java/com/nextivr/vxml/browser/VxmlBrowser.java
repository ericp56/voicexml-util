package com.nextivr.vxml.browser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 * This class has an internal HTTP client that performs HTTP GET and POST
 * methods, and returns the results in an {@link HttpResponse} object.
 */
public class VxmlBrowser {
    CloseableHttpClient httpclient;
    List<NameValuePair> postFields = new ArrayList<NameValuePair>();

    public VxmlBrowser() {
        httpclient = HttpClients.createDefault();
    }

    /**
     * A simple HTTP GET with the resulting message, headers and status
     * 
     * @param urlString
     * @return {@link HttpResponse} of response info
     * @throws Exception if there were any underlying http exceptions
     */
    public HttpResponse fetchDocument(String urlString) throws Exception {
        HttpResponse ret;

        HttpGet httpGet = new HttpGet(urlString);
        try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
            HttpEntity entity1 = response1.getEntity();
            String message = new String(entity1.getContent().readAllBytes());
            Header[] headers = response1.getAllHeaders();
            StatusLine statusLine = response1.getStatusLine();
            ret = new HttpResponse(message, headers, statusLine);
        }

        return ret;
    }

    /**
     * post to the urlString the fields added via the addField method
     * 
     * @param urlString
     * @return
     * @throws Exception
     */
    public HttpResponse postDocument(String urlString) throws Exception {
        HttpResponse ret;

        HttpPost postRequest = new HttpPost(urlString);
        postRequest.setEntity(new UrlEncodedFormEntity(postFields, Consts.UTF_8));
        try (CloseableHttpResponse response1 = httpclient.execute(postRequest)) {
            HttpEntity entity1 = response1.getEntity();
            String message = new String(entity1.getContent().readAllBytes());
            Header[] headers = response1.getAllHeaders();
            StatusLine statusLine = response1.getStatusLine();
            ret = new HttpResponse(message, headers, statusLine);
            postFields.clear();
        }

        return ret;
    }

    /**
     * add a field for the next post
     * 
     * @param name
     * @param value
     */
    public void addField(String name, String value) {
        postFields.add(new BasicNameValuePair(name, value));
    }

    /**
     * clean up the {@link CloseableHttpClient}
     */
    protected void finalize() {
        try {
            httpclient.close();
        } catch (IOException ex) {

        }
    }

}
