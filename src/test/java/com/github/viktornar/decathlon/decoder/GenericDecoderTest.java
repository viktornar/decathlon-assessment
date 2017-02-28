package com.github.viktornar.decathlon.decoder;

import com.github.viktornar.decathlon.model.Athlete;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.util.List;

import static com.github.viktornar.decathlon.constants.Constants.CSV_DECODER;
import static com.github.viktornar.decathlon.constants.Constants.DEFAULT_INPUT_FILE_PATH;
import static com.github.viktornar.decathlon.constants.Constants.XML_DECODER;
import static org.junit.Assert.*;


public class GenericDecoderTest {
    private String lineToParse;
    private Decoder genericDecoder;

    @Before
    public void setUp() throws Exception {
        lineToParse = "Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72";
        genericDecoder = new GenericDecoder(CSV_DECODER);
    }

    @Test
    public void decode() throws Exception {
        Athlete athlete = genericDecoder.decode(lineToParse);
        Assert.assertNotNull(genericDecoder);
        Assert.assertEquals("Siim Susi", athlete.getFullName());
        Assert.assertEquals(10, athlete.getRecords().size());
        Assert.assertTrue(5.00 == athlete.getRecords().get(1));
        Assert.assertTrue(athlete.getResult().getPlace().equals(""));
    }

    @Test
    public void readData() throws Exception {
        List<Athlete> athletes = genericDecoder.readData(
                new File(getClass().getClassLoader().getResource(DEFAULT_INPUT_FILE_PATH).getFile())
        );

        Assert.assertTrue(athletes.size() == 7);
        Assert.assertEquals("Siim Susi", athletes.get(0).getFullName());
        Assert.assertTrue(12.61 == athletes.get(0).getRecords().get(0));
    }

    @Test(expected = NotImplementedException.class)
    public void constructor() throws Exception {
        Decoder notImplementedGenericDecoder = new GenericDecoder(XML_DECODER);
    }
}