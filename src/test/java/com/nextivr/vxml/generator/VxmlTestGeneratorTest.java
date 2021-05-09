package com.nextivr.vxml.generator;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.nextivr.vxml.voicexml21.Vxml;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class VxmlTestGeneratorTest extends TestCase {
    public VxmlTestGeneratorTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(VxmlTestGeneratorTest.class);
    }

    public void testSimpleTest() throws Exception {
        VxmlTestGenerator tg = new VxmlTestGenerator();
        com.nextivr.vxml.generator.Test vxmlTest = new com.nextivr.vxml.generator.Test();
        vxmlTest.addStep(new Step("greeting", "lang", "Hello, {*} thank you for calling.", "", "", "5000ms", "1500ms"));
        vxmlTest.addStep(
                new Step("lang", "mainmenu", "Press 1 for English, 2 for Spanish", "", "one", "5000ms", "1500ms"));
        vxmlTest.addStep(new Step("mainmenu", "", "For billing, press 1.  For customer service, press 2.", "05251900",
                "", "5000ms", "1500ms"));
        Vxml v = tg.generateVxml(vxmlTest);

        JAXBContext context = JAXBContext.newInstance(Vxml.class);
        StringWriter writer = new StringWriter();
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(v, writer);
        writer.close();
        System.out.println(writer.toString());
        // assertTrue(writer.toString().contains("catch event"));
    }
}
