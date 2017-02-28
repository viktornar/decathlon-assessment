package com.github.viktornar.decathlon.accessor;

import com.github.viktornar.decathlon.model.Athlete;

import java.util.List;

/**
 *
 * @author v.nareiko
 */
public interface Assessor {
    void rate(List<Athlete> athletes);
    void reward(List<Athlete> athletes);
}
