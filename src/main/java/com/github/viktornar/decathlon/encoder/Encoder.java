package com.github.viktornar.decathlon.encoder;

import java.io.File;

/**
 *
 * @author v.nareiko
 */
public interface Encoder {
    String encode(Object objectsToBeBound, Class... classesToBeBound);
    void writeData(File output, String dataToWrite);
}
