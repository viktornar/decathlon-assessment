package com.github.viktornar.decathlon.judge;

import com.github.viktornar.decathlon.decoder.CSVDecoder;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;

import static com.github.viktornar.decathlon.constants.Constants.CSV_DECODER;
import static com.github.viktornar.decathlon.constants.Constants.DEFAULT_INPUT_FILE_PATH;
import static com.github.viktornar.decathlon.constants.Constants.XML_ENCODER;


public class JudgeTest {
    private Judge judge;
    @Before
    public void setUp() throws Exception {
        judge = new JudgeFactory().createJudge(CSV_DECODER, XML_ENCODER);
    }

    @Test
    public void makeVerdict() throws Exception {
        final File input = new File(getClass().getClassLoader().getResource(DEFAULT_INPUT_FILE_PATH).getFile());
        final File output = File.createTempFile("temp_", Long.toString(System.nanoTime()) + ".xml");

        judge.makeVerdict(input, output);

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(output);
        }
    }

    @Test
    public void makeVerdict1() throws Exception {
        final File input = new File(getClass().getClassLoader().getResource(DEFAULT_INPUT_FILE_PATH).getFile());
        judge.makeVerdict(input);
    }

}