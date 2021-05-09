package com.nextivr.vxml.generator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.List;

import com.nextivr.vxml.Vxml21Marshaller;
import com.nextivr.vxml.voicexml21.Vxml;

/**
 * This is the main app that will generate a VXML test case, based on the CSV
 * file provided. The VXML file will have the same path and filename as the CSV
 * file, but with the extension .vxml.  The file should have the layout as specified by {@link ImportCsv.FileHeaders}
 */
public class ProcessCsvToVxml {

    public static void main(String[] args) throws Exception {
        String fileNameAndPath = args[0];
        String fileNameParts[] = fileNameAndPath.split("[/\\.]");
        String formName = fileNameParts[fileNameParts.length - 2].replaceAll("[^a-zA-Z0-9]", "_");
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
        Vxml21Marshaller vxmlConverter = new Vxml21Marshaller();
        vxmlConverter.toStream(newVxml, writer);

    }

}
