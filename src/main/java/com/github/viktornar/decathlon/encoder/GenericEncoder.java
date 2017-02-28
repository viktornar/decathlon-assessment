package com.github.viktornar.decathlon.encoder;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;

import static com.github.viktornar.decathlon.constants.Constants.XML_ENCODER;

/**
 * Generic encoder for writing verdict about athletes by given format
 *
 * @author v.nareiko
 */
public class GenericEncoder implements Encoder {
    private Encoder encoder = null;

    public GenericEncoder(String type) {
        if (type.equals(XML_ENCODER)) {
            encoder = new XMLEncoder();
        }

        if (encoder == null) throw new NotImplementedException();
    }

    /**
     * Marshal object to given format
     *
     * @param objectsToBeBound - object to marshal
     * @param classesToBeBound - type of object
     * @return - encoded string
     */
    @Override
    public String encode(Object objectsToBeBound, Class... classesToBeBound) {
        return encoder.encode(objectsToBeBound, classesToBeBound);
    }

    /**
     * Write encode results
     *
     * @param output      - file to write encoded string into
     * @param dataToWrite - encoded string
     */
    @Override
    public void writeData(File output, String dataToWrite) {
        encoder.writeData(output, dataToWrite);
    }
}
