package com.nextivr.utils;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.nextivr.model.Step;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Hello world!
 *
 */
public class ImportCsv {

    enum FileHeaders {
        name, next, listen_for_voice, respond_with_dtmf, respond_with_voice, reco_timeout, complete_timeout
    }

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
            if(complete_timeout.equals(FileHeaders.complete_timeout.name())) {
                continue;
            }
            Step step = new Step(name, next, listen_for_voice, respond_with_dtmf, respond_with_voice, reco_timeout,
                    complete_timeout);
            steps.add(step);
        }

        return steps;

    }
}
