package com.github.viktornar.decathlon.encoder;

import com.github.viktornar.decathlon.decoder.GenericDecoder;
import com.github.viktornar.decathlon.model.Athlete;
import com.github.viktornar.decathlon.model.Competition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.io.File;
import java.util.Arrays;

import static com.github.viktornar.decathlon.constants.Constants.CSV_ENCODER;
import static com.github.viktornar.decathlon.constants.Constants.XML_DECODER;
import static com.github.viktornar.decathlon.constants.Constants.XML_ENCODER;
import static org.junit.Assert.*;


public class GenericEncoderTest {
    private GenericEncoder encoder;
    private Athlete athlete;
    private Competition competition;

    @Before
    public void setUp() {
        athlete = new Athlete();

        athlete.setFullName("Foo Bar");
        athlete.setRecords(Arrays.asList(12.61, 5.00, 9.22, 1.50, 60.39, 16.43, 21.60, 2.60, 35.81, 5.25));
        competition = new Competition();
        competition.setAthletes(Arrays.asList(athlete));

        encoder = new GenericEncoder(XML_ENCODER);
    }

    @Test
    public void encode() throws Exception {
        String xmlString = encoder.encode(competition, Competition.class);

        Assert.assertNotNull(xmlString);
        Assert.assertTrue(!xmlString.isEmpty());

    }

    @Test
    public void writeData() throws Exception {
        String xmlString = encoder.encode(competition, Competition.class);
        final File file = File.createTempFile("temp_", Long.toString(System.nanoTime()) + ".xml");

        encoder.writeData(file, xmlString);

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(file);
        }
    }

    @Test(expected = NotImplementedException.class)
    public void constructor() throws Exception {
        Encoder notImplementedGenericDecoder = new GenericEncoder(CSV_ENCODER);
    }

}