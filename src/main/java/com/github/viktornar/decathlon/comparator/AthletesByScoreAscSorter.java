package com.github.viktornar.decathlon.comparator;

import com.github.viktornar.decathlon.model.Athlete;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author v.nareiko
 */
public class AthletesByScoreAscSorter implements Comparator<Athlete>, Serializable {
    @Override
    public int compare(Athlete left, Athlete right) {
        if (left.getResult().getScore() > right.getResult().getScore()){
            return 1;
        }else{
            return -1;
        }
    }
}
