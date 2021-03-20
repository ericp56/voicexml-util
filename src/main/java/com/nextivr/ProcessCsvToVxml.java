package com.nextivr;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.nextivr.model.Step;
import com.nextivr.model.Test;
import com.nextivr.utils.ImportCsv;
import com.nextivr.utils.VxmlTestGenerator;
import com.nextivr.voicexml21.Vxml;

public class ProcessCsvToVxml {

    public static void main(String[] args) throws Exception{
        String fileNameAndPath = args[0];
        String fileNameParts[] = fileNameAndPath.split("[/\\.]");
        String formName = fileNameParts[fileNameParts.length-2].replaceAll("[^a-zA-Z0-9]", "_");
        Reader in = new FileReader(fileNameAndPath);

        ImportCsv importer = new ImportCsv();
        List<Step> steps = importer.GetListFromFile(in);

        String outFileName = args[0].replaceAll("\\.csv$", ".vxml");
        
        VxmlTestGenerator generator = new VxmlTestGenerator();
        Test test = new Test();
        test.setTestName(formName);
        test.setSteps(steps);
        Vxml newVxml = generator.generateVxml(test);

        FileWriter writer = new FileWriter(outFileName);
        JAXBContext context = JAXBContext.newInstance(Vxml.class);  
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(newVxml, writer);
        writer.close();
    }
    
}
