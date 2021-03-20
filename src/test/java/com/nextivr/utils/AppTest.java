package com.nextivr.utils;

import java.io.File;
import java.io.StringWriter;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.nextivr.voicexml21.Catch;
import com.nextivr.voicexml21.ObjectFactory;
import com.nextivr.voicexml21.Vxml;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMarshall() throws Exception
    {

        ObjectFactory oo = new ObjectFactory();
        Vxml v = oo.createVxml();
        v.setLang("en-US");
        v.setVersion("2.1");
        Catch c = oo.createCatch();
        c.setCond("connection.disconnect");
        c.setCount(BigInteger.ONE);
        v.getDataOrCatchOrHelp().add(c);
        JAXBContext context = JAXBContext.newInstance(Vxml.class);  
        StringWriter writer = new StringWriter();
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(v, writer);
        writer.close();
        assertTrue(writer.toString().contains("catch cond"));
    }
    public void testUnmarshall() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Vxml.class);  
        String selectedFile = "./src/test/resources/sample-vxml.xml";
        Unmarshaller um = context.createUnmarshaller();
        Object ob = um.unmarshal(new File(selectedFile));
        Vxml input = (Vxml) ob;
        assert("2.1".equals(input.getVersion()));

    }
}
