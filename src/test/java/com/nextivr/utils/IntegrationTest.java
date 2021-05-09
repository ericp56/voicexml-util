package com.nextivr.utils;

import com.nextivr.vxml.browser.HttpResponse;
import com.nextivr.vxml.browser.VxmlBrowser;

import org.apache.http.HttpStatus;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class IntegrationTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public IntegrationTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(IntegrationTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testSimpleGet() throws Exception {
        VxmlBrowser vb = new VxmlBrowser();
        String urlString = "http://www.nextivr.com";
        HttpResponse fetchDocument = vb.fetchDocument(urlString);
        assertEquals(HttpStatus.SC_OK, fetchDocument.getStatusLine().getStatusCode());
        //crazy assumption that Content-Length is always the 2nd header.  good enough for dev validation.
        //TODO make a Util class for Headers - if it's never needed, remove headers from the response!
        int expectedLength = Integer.parseInt(fetchDocument.getHeaders()[1].getValue());
        int actualLength = fetchDocument.getMessage().length();
        assertEquals(true, expectedLength != 0 && actualLength != 0);
    }
}
