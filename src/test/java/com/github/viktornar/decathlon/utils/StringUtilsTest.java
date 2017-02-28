package com.github.viktornar.decathlon.utils;

import org.junit.Test;

import static org.junit.Assert.*;


public class StringUtilsTest {
    @Test
    public void isNumeric() throws Exception {
        assertTrue(StringUtils.isNumeric("9288.2"));
        assertTrue(StringUtils.isNumeric("9288,2"));
        assertFalse(StringUtils.isNumeric("928w,2"));
        // This is ok. 928:2 interpreted as special type of numeric [minute:seconds] (time)
        assertTrue(StringUtils.isNumeric("928:2"));
    }

    @Test
    public void isAlphaNumeric() throws Exception {
        assertTrue(StringUtils.isAlphaNumeric("w2"));
        assertTrue(StringUtils.isAlphaNumeric("w 2"));
        assertFalse(StringUtils.isAlphaNumeric("9288.2"));
        assertTrue(StringUtils.isAlphaNumeric("ssfsf"));
    }

    @Test
    public void isDoublePoint() throws Exception {
        assertTrue(StringUtils.isDoublePoint("92.88.2"));
        assertFalse(StringUtils.isDoublePoint("9288.2"));
    }

    @Test
    public void isColon() throws Exception {
        assertTrue(StringUtils.isColon("92:882"));
        assertFalse(StringUtils.isColon("9288.2"));
    }

    @Test
    public void isValidDouble() throws Exception {
        assertTrue(StringUtils.isValidDouble("92.882"));
        assertTrue(StringUtils.isValidDouble("92,882"));
        assertFalse(StringUtils.isValidDouble("928.8.2"));
    }

    @Test
    public void bothTrim() throws Exception {
        assertEquals("ksksk ksk", StringUtils.bothTrim(" ksksk ksk "));
    }

    @Test
    public void toDouble() throws Exception {
        assertTrue(325.72 == StringUtils.toDouble("5.25.72"));
    }

}