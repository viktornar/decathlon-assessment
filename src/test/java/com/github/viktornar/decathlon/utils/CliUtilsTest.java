package com.github.viktornar.decathlon.utils;

import org.junit.Test;

import java.util.Map;

import static com.github.viktornar.decathlon.constants.Constants.INPUT_ARG_NAME;
import static com.github.viktornar.decathlon.constants.Constants.OUTPUT_ARG_NAME;
import static org.junit.Assert.*;


public class CliUtilsTest {
    @Test
    public void parseArguments() throws Exception {
        Map<String, String> arguments = CliUtils.parseArguments("--output", "foo.bar", "--input", "bar.foo");

        assertNotNull(arguments.get(OUTPUT_ARG_NAME));
        assertNotNull(arguments.get(INPUT_ARG_NAME));
        assertEquals("foo.bar", arguments.get(OUTPUT_ARG_NAME));
        assertEquals("bar.foo", arguments.get(INPUT_ARG_NAME));

        arguments = CliUtils.parseArguments("-ss", "sss", "input", "bar.foo");

        assertNull(arguments.get(OUTPUT_ARG_NAME));
        assertNull(arguments.get(INPUT_ARG_NAME));

    }

}