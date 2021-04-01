package com.nextivr.utils;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.nextivr.model.Step;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * This class will take a csv with the headers, as listed in the FileHeaders
 * enum, and process the file into test steps. These steps can then be used to
 * generate a vxml file of the test.
 */
public class ImportCsv {

    /**
     * For the file format with columns: 
     *name, next, listen_for_voice, respond_with_dtmf, respond_with_voice, reco_timeout, complete_timeout
     */
    public enum FileHeaders {
        name, next, listen_for_voice, respond_with_dtmf, respond_with_voice, reco_timeout, complete_timeout
    }

    /**
     * 
     * @param input io Reader of the input stream/document.
     * @return a List of Step objects.
     * @throws Exception
     */
    public List<Step> GetListFromFile(Reader input) throws Exception {
        List<Step> steps = new ArrayList<Step>();

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(FileHeaders.class).parse(input);

        for (CSVRecord record : records) {
            String name = record.get(FileHeaders.name);
            String next = record.get(FileHeaders.next);
            String listen_for_voice = record.get(FileHeaders.listen_for_voice);
            String respond_with_dtmf = record.get(FileHeaders.respond_with_dtmf);
            String respond_with_voice = record.get(FileHeaders.respond_with_voice);
            String reco_timeout = record.get(FileHeaders.reco_timeout);
            String complete_timeout = record.get(FileHeaders.complete_timeout);
            if (complete_timeout.equals(FileHeaders.complete_timeout.name())) {
                continue;
            }
            Step step = new Step(name, next, listen_for_voice, respond_with_dtmf, respond_with_voice, reco_timeout,
                    complete_timeout);
            steps.add(step);
        }

        return steps;

    }
}
