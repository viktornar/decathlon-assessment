package com.github.viktornar.decathlon.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

/**
 *
 * @author v.nareiko
 */
@XmlRootElement
public class Athlete extends Model {
    private String fullName = "";
    private Result result = new Result();
    private List<Double> records = new ArrayList<>();

    public String getFullName() {
        return fullName;
    }

    @XmlElement
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Result getResult() {
        return result;
    }

    @XmlElement
    public void setResult(Result result) {
        this.result = result;
    }

    @XmlElementWrapper(name="records")
    @XmlElement(name="record")
    public List<Double> getRecords() {
        return records;
    }

    public void setRecords(List<Double> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return format("{fullName: '%s', record: %s, result: %s}",
                fullName,
                Arrays.toString(records.toArray()),
                result);
    }
}
