package com.github.viktornar.decathlon.decoder;

import com.github.viktornar.decathlon.model.Athlete;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.util.List;

import static com.github.viktornar.decathlon.constants.Constants.CSV_DECODER;

/**
 * Generic encoder for reading athletes records
 *
 * @author v.nareiko
 */
public class GenericDecoder implements Decoder {
    private Decoder decoder = null;

    public GenericDecoder(String type) {
        if (type.equals(CSV_DECODER)) {
            decoder = new CSVDecoder();
        }

        if (decoder == null) throw new NotImplementedException();
    }

    @Override
    public Athlete decode(String input) {
        return decoder.decode(input);
    }

    @Override
    public List<Athlete> readData(File file) {
        return decoder.readData(file);
    }
}
