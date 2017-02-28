package com.github.viktornar.decathlon.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * CLI utils for command arguments parsing
 *
 * @author v.nareiko
 */
public class CliUtils {
    /**
     * Parse arguments by given argument list from main method
     * @param args - arguments as string array
     * @return - parsed arguments store in map to get access by key that mapped to constants
     */
    public static Map<String, String> parseArguments(String... args) {
        HashMap<String, String> arguments = new HashMap<String, String>();

        String key = null;
        String value = null;
        int index = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("--")) {
                key = args[i].substring(2);
            } else {
                arguments.put(args[i], null);
                continue;
            }

            if ((i + 1) < args.length) {
                if (args[i + 1].charAt(0) != '-') {
                    arguments.put(key, args[i + 1]);
                    i++;
                } else {
                    arguments.put(args[i], null);
                }
            } else {
                arguments.put(args[i], null);
            }
        }
        return arguments;
    }
}
