package com.github.viktornar.decathlon.decoder;

import com.github.viktornar.decathlon.model.Athlete;

import java.io.File;
import java.util.List;

/**
 *
 * @author v.nareiko
 */
public interface Decoder {
    Athlete decode(String input);
    List<Athlete> readData(File file);
}
