package com.nextivr.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.nextivr.voicexml21.Vxml;

public class Vxml21 {
    public Vxml fromString(String vxmlString) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Vxml.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        InputStream inputStream = new ByteArrayInputStream(vxmlString.getBytes());
        InputStreamReader streamReader = new InputStreamReader(inputStream);

        Vxml doc = (Vxml) unmarshaller.unmarshal(streamReader);

        return doc;

    }

}
