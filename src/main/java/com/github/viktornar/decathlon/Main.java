package com.github.viktornar.decathlon;

import com.github.viktornar.decathlon.judge.JudgeFactory;
import com.github.viktornar.decathlon.judge.Judge;
import com.github.viktornar.decathlon.utils.CliUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import static com.github.viktornar.decathlon.constants.Constants.*;
import static java.lang.String.format;

public class Main {
    public static void main(String... args) throws IOException, JAXBException {
        Map<String, String> arguments = CliUtils.parseArguments(args);
        String inputFile = "";

        if (arguments.get(INPUT_ARG_NAME) != null) {
            inputFile = arguments.get(INPUT_ARG_NAME);
        } else {
            System.out.println(format("--%s - was not specified. Usage example: --%s [csv_filename] . Program will be terminated", INPUT_ARG_NAME, INPUT_ARG_NAME));
            System.exit(0);
        }

        Judge judge = new JudgeFactory().createJudge(CSV_DECODER, XML_ENCODER);

        if (arguments.get(OUTPUT_ARG_NAME) != null) {
            String outputFile = arguments.get(OUTPUT_ARG_NAME);
            judge.makeVerdict(new File(inputFile), new File(outputFile));
        } else {
            System.out.println(format("--%s - was not specified. Usage example: --%s [xml_filename] Result will be displayed in console\n", OUTPUT_ARG_NAME, OUTPUT_ARG_NAME));
            judge.makeVerdict(new File(inputFile));
        }
    }
}
