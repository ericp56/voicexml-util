package com.nextivr.vxml.browser;

import org.apache.http.HttpStatus;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class VxmlBrowserTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public VxmlBrowserTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(VxmlBrowserTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testSimpleGet() throws Exception {
        VxmlBrowser vb = new VxmlBrowser();
        String urlString = "http://www.nextivr.com";
        HttpResponse fetchDocument = vb.fetchDocument(urlString);
        assertEquals(HttpStatus.SC_OK, fetchDocument.getStatusLine().getStatusCode());
        int expectedLength = Integer.parseInt(fetchDocument.getHeaderValue("content-length"));
        int actualLength = fetchDocument.getMessage().length();
        assertEquals(true, expectedLength != 0 && actualLength != 0);
    }
}
