package com.github.viktornar.decathlon.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static java.lang.String.format;

/**
 *
 * @author v.nareiko
 */
@XmlRootElement
public class Result extends Model {
    private Integer score = 0;
    private String place = "";

    public Integer getScore() {
        return score;
    }

    @XmlElement
    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPlace() {
        return place;
    }

    @XmlElement
    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return format("{ place: '%s', score: '%s' }", place, score);
    }
}
