package com.github.viktornar.decathlon.utils;

import java.util.regex.Pattern;
import static com.github.viktornar.decathlon.constants.Constants.COLON;
import static com.github.viktornar.decathlon.constants.Constants.PERIOD;
import static com.github.viktornar.decathlon.constants.Constants.COMMA;
import static com.github.viktornar.decathlon.constants.Constants.EMPTY;

/**
 * Utils related to operations with strings
 *
 * @author v.nareiko
 */
public class StringUtils {
    private static Pattern left, right;

    /**
     * Check if string is numeric only
     * @param str - string to check
     * @return - true or false depend on string origin
     */
    public static boolean isNumeric(String str) {
        // Maybe it is better to use regexp to check this as it is done in isDoublePoint method
        // but this part of code migrate from my old project so don't want to investigate
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)
                    && c != PERIOD.charAt(0)
                    && c != COLON.charAt(0)
                    && c != COMMA.charAt(0))
                return false;
        }
        return true;
    }

    /**
     * Check if string is isAlphaNumeric
     * @param str - string to check
     * @return - true or false depend on string origin
     */
    public static boolean isAlphaNumeric(String str) {
        // Maybe it is better to use regexp to check this as it is done in isDoublePoint method
        // but this part of code migrate from my old project so don't want to investigate
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isLetter(c) && !Character.isSpaceChar(c))
                return false;
        }
        return true;
    }

    /**
     * Check if string has double points
     * @param str - string to check
     * @return true or false depend on string origin
     */
    public static boolean isDoublePoint(String str) {
        return str.split("\\" + PERIOD).length > 2;
    }

    /**
     * Check if string has colon
     * @param str - string to check
     * @return true or false depend on string origin
     */
    public static boolean isColon(String str) {
        return str.split("" + COLON).length > 1;
    }

    /**
     * Check if string is valid double
     * @param str - string to check
     * @return true or false depend on string origin
     */
    public static boolean isValidDouble(String str) {
        return !(isDoublePoint(str) || isColon(str));
    }

    /**
     * Trim string from left
     * @param input - string to trim
     * @return - trimmed string
     */
    private static String leftTrim(String input) {
        return (left != null ? left : (left = Pattern.compile("\\A(?:\\s)+"))).matcher(input).replaceAll(EMPTY);
    }

    /**
     * Trim string from right
     * @param input - string to trim
     * @return - trimmed string
     */
    private static String rightTrim(String input) {
        return (right != null ? right : (right = Pattern.compile("(?:\\s)+\\z"))).matcher(input).replaceAll(EMPTY);
    }

    /**
     * Trim string from left and right
     * @param input - string to trim
     * @return - trimmed string
     */
    public static String bothTrim(String input) {
        return leftTrim(rightTrim(input));
    }

    /**
     * Parse string with double points. Double points in string is weird
     * notation for time: [mintes]:[seconds].[milisecond]
     * @param str - string to parse
     * @return - Double that represents time in seconds
     */
    public static Double toDouble(String str) {
        String[] splitted = str.split("\\" + PERIOD);
        return Double.parseDouble(splitted[0]) * 60 +
                Double.parseDouble(splitted[1]) +
                Double.parseDouble(splitted[2]) / 100;
    }
}

