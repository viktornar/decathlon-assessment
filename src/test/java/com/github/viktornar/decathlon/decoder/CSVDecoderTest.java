package com.github.viktornar.decathlon.decoder;

import com.github.viktornar.decathlon.model.Athlete;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static com.github.viktornar.decathlon.constants.Constants.DEFAULT_INPUT_FILE_PATH;

public class CSVDecoderTest {
    private String lineToParse;
    private Decoder csvDecoder;

    @Before
    public void setUp(){
        lineToParse = "Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72";
        csvDecoder = new CSVDecoder();
    }

    @Test
    public void decode() throws Exception {
        Athlete athlete = csvDecoder.decode(lineToParse);
        Assert.assertNotNull(csvDecoder);
        Assert.assertEquals("Siim Susi", athlete.getFullName());
        Assert.assertEquals(10, athlete.getRecords().size());
        Assert.assertTrue(12.61 == athlete.getRecords().get(0));
        Assert.assertTrue(athlete.getResult().getPlace().equals(""));
    }

    @Test
    public void readData() throws Exception {
        List<Athlete> athletes = csvDecoder.readData(
                new File(getClass().getClassLoader().getResource(DEFAULT_INPUT_FILE_PATH).getFile())
        );

        Assert.assertTrue(athletes.size() == 7);
        Assert.assertEquals("Siim Susi", athletes.get(0).getFullName());
        Assert.assertTrue(12.61 == athletes.get(0).getRecords().get(0));
    }

    // Test if error are handled properly. Should log error and then return empty list
    @Test
    public void readDataException() throws Exception {
        List<Athlete> athletes = csvDecoder.readData(
                new File(getClass().getClassLoader().getResource(DEFAULT_INPUT_FILE_PATH).getFile() + "foobar")
        );

        Assert.assertTrue(athletes.size() == 0);
    }
}