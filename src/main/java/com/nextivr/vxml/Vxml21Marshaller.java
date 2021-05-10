package com.nextivr.vxml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.nextivr.vxml.voicexml21.Vxml;

public class Vxml21Marshaller {
    /**
     * Load the vxmlstring parameter into a {@link Vxml} object
     * @param vxmlString
     * @return a new {@link Vxml} object
     * @throws Exception
     */
    public Vxml fromString(String vxmlString) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Vxml.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        InputStream inputStream = new ByteArrayInputStream(vxmlString.getBytes());
        InputStreamReader streamReader = new InputStreamReader(inputStream);

        Vxml doc = (Vxml) unmarshaller.unmarshal(streamReader);

        return doc;

    }

    /**
     * Write the {@link Vxml} document to an {@link OutputStreamWriter}
     * @param newVxml
     * @param writer
     * @throws Exception
     */
    public void toStream(Vxml newVxml, OutputStreamWriter writer) throws Exception{
        JAXBContext context = JAXBContext.newInstance(Vxml.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(newVxml, writer);
        writer.close();
    }

}
