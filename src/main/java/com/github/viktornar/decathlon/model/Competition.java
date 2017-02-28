package com.github.viktornar.decathlon.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

/**
 *
 * @author v.nareiko
 */
@XmlRootElement
public class Competition extends Model {
    private List<Athlete> athletes;

    public List<Athlete> getAthletes() {
        return athletes;
    }

    @XmlElement(name = "athlete")
    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    @Override
    public String toString() {
        return format("{athletes: %s}", Arrays.toString(athletes.toArray()));
    }
}
