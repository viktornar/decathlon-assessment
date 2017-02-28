package com.github.viktornar.decathlon.decoder;

import com.github.viktornar.decathlon.model.Athlete;
import com.github.viktornar.decathlon.utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.github.viktornar.decathlon.constants.Constants.*;
import static com.github.viktornar.decathlon.utils.StringUtils.bothTrim;
import static com.github.viktornar.decathlon.utils.StringUtils.isNumeric;
import static com.github.viktornar.decathlon.utils.StringUtils.isValidDouble;
import static com.github.viktornar.decathlon.utils.StringUtils.toDouble;

/**
 * Concrete implementation on decoder. Do not use it directly. Should be initialized through GenericDecoder
 *
 * @author v.nareiko
 */
public class CSVDecoder implements Decoder {
    private String separator = SEMI_COLON;
    private List<String> athletes = new ArrayList<>();
    public CSVDecoder() {
        this(SEMI_COLON);
    }
    private CSVDecoder(String separator) {
        this.separator = separator;
    }

    @Override
    public Athlete decode(String input) {
        /*
            It's possible to use scanner here:
            Scanner s = new Scanner(input).useDelimiter("\\" + separator);
            athlete.setFullName(s.next());
            ...
            It's a little easier to parse current csv because scanner can return string or Double
        */

        String[] row = input.split(separator);
        Athlete athlete = new Athlete();
        List<Double> records = new ArrayList<>();
        Arrays.stream(row).forEach((col) -> {
            String item = bothTrim(col);
            if (isNumeric(item)) {
                if (isValidDouble(item)) {
                    records.add(Double.parseDouble(item));
                } else {
                    records.add(toDouble(item));
                }
            } else {
                athlete.setFullName(item);
            }
        });

        athlete.setRecords(records);

        return athlete;
    }

    @Override
    public List<Athlete> readData(File file) {
        List<Athlete> athletes = new ArrayList<>();
        List<String> lines = FileUtils.readData(file);
        lines.forEach((line) -> {
            Athlete athlete = decode(line);
            athletes.add(athlete);
        });

        return athletes;
    }
}
