package com.github.viktornar.decathlon.constants;

/**
 * Constants that should be used across all application
 *
 * @author v.nareiko
 */
public class Constants {
    public final static String DEFAULT_INPUT_FILE_PATH = "data/Decathlon_input.txt";
    public final static String XSLT_INPUT_FILE_PATH = "xsl/decathlon.xsl";
    public final static String XSLT_FILE_NAME = "decathlon.xsl";
    public final static String EMPTY = "";
    public final static String COLON = ":";
    public final static String PERIOD = ".";
    public final static String COMMA = ",";
    public final static String SEMI_COLON = ";";

    public final static Double[] RUN_OF_100M = new Double[]{25.4347, 18.0, 1.81};
    public final static Double[] LONG_JUMP = new Double[]{0.14354, 220.0, 1.4};
    public final static Double[] SHOT_PUT = new Double[]{51.39, 1.5, 1.05};
    public final static Double[] HIGH_JUMP = new Double[]{0.8465, 75.0, 1.42};
    public final static Double[] RUN_OF_400M = new Double[]{1.53775, 82.0, 1.81};
    public final static Double[] HURDLES_OF_110M = new Double[]{5.74352, 28.5, 1.92};
    public final static Double[] DISCUS_THROW = new Double[]{12.91, 4.0, 1.1};
    public final static Double[] POLE_VAULT = new Double[]{0.2797, 100.0, 1.35};
    public final static Double[] JAVELIN_THROW = new Double[]{10.14, 7.0, 1.08};
    public final static Double[] RUN_OF_1500M = new Double[]{0.03768, 480.0, 1.85};

    public final static String INPUT_ARG_NAME = "input";
    public final static String OUTPUT_ARG_NAME = "output";

    public final static String XSLT_HEADER = "<?xml-stylesheet type=\"text/xsl\" href=\"decathlon.xsl\"?>";
    public final static String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    public final static String CSV_DECODER = "csv";
    public final static String XML_DECODER = "xml";
    public final static String CSV_ENCODER = "csv";
    public final static String XML_ENCODER = "xml";

    public final static String ACCESS_DENIED_EXCEPTION = "Denied access for creating file";

    public final static int BUFFER_SIZE = 2 * 1024 * 1024;
}
