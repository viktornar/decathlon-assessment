package com.github.viktornar.decathlon.accessor;

import com.github.viktornar.decathlon.decoder.CSVDecoder;
import com.github.viktornar.decathlon.decoder.Decoder;
import com.github.viktornar.decathlon.model.Athlete;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class DecathlonAssessorTest {
    private List<String> linesToParse;
    private Decoder csvDecoder;
    private List<Athlete> athletes;
    private DecathlonAssessor assessor;

    @Before
    public void setUp() throws Exception {
        linesToParse = Arrays.asList(
                "Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72",
                "Siim Susi 2;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72",
                "Beata Kana;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76",
                "Anti Loop;13.43;4.35;8.64;1.50;66.06;19.05;24.89;2.20;33.48;6.51.01"
        );
        csvDecoder = new CSVDecoder();
        athletes = Arrays.asList(
                csvDecoder.decode(linesToParse.get(0)),
                csvDecoder.decode(linesToParse.get(1)),
                csvDecoder.decode(linesToParse.get(2))
        );

        assessor = new DecathlonAssessor();
    }

    @Test
    public void rate() throws Exception {
        assessor.rate(athletes);
        Assert.assertTrue(3946 == athletes.get(0).getResult().getScore());
    }

    @Test
    public void reward() throws Exception {
        assessor.rate(athletes);
        assessor.reward(athletes);
        Assert.assertEquals("1-2", athletes.get(0).getResult().getPlace());
    }
}