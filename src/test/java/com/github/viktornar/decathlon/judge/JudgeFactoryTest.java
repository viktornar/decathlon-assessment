package com.github.viktornar.decathlon.judge;


import org.junit.Assert;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.github.viktornar.decathlon.constants.Constants.CSV_DECODER;
import static com.github.viktornar.decathlon.constants.Constants.XML_DECODER;
import static com.github.viktornar.decathlon.constants.Constants.XML_ENCODER;


public class JudgeFactoryTest {
    @Test
    public void createJudge() throws Exception {
        JudgeFactory judgeFactory = new JudgeFactory();
        Judge judge = judgeFactory.createJudge(CSV_DECODER, XML_ENCODER);
        Assert.assertNotNull(judge);
    }

    @Test(expected = NotImplementedException.class)
    public void createJudgeNot() throws Exception {
        JudgeFactory judgeFactory = new JudgeFactory();
        Judge judge = judgeFactory.createJudge(XML_DECODER, CSV_DECODER);
    }

}