package com.github.viktornar.decathlon.accessor;

import com.github.viktornar.decathlon.comparator.AthletesByScoreDescSorter;
import com.github.viktornar.decathlon.model.Athlete;

import static com.github.viktornar.decathlon.constants.Constants.*;

import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.round;

/**
 * Main engine for making assessments on athletes
 *
 * @author v.nareiko
 */
public class DecathlonAssessor implements Assessor {
    private Double[][] coefficients = new Double[][]{
            RUN_OF_100M,
            LONG_JUMP,
            SHOT_PUT,
            HIGH_JUMP,
            RUN_OF_400M,
            HURDLES_OF_110M,
            DISCUS_THROW,
            POLE_VAULT,
            JAVELIN_THROW,
            RUN_OF_1500M
    };

    /**
     * Rate athletes by decathlon formula that can be found in wikipedia
     *
     * @param athletes - athletes to rate
     */
    @Override
    public void rate(List<Athlete> athletes) {
        athletes.forEach((athlete -> {
            Double score = 0.0;

            List<Double> records = athlete.getRecords();
            int size = athlete.getRecords().size();
            int coeficientsSize = coefficients.length;

            // Make assumptions that data always comes in the same order corresponding to competition event
            // Just in case iteration is done by different idx to avoid IndexOutOfBox error.
            for (int i = 0, j = 0; j < coeficientsSize && i < size; i++, j++) {
                Double a = coefficients[j][0];
                Double b = coefficients[j][1];
                Double c = coefficients[j][2];

                // Round scores. No need express them in big accuracy?
                score += round(a * pow(abs(records.get(i) - b), c));
            }

            athlete.getResult().setScore(score.intValue());
        }));
    }

    /**
     * Rewards athletes by give them corresponding places
     *
     * @param athletes - athletes to rate
     */
    @Override
    public void reward(List<Athlete> athletes) {
        athletes.sort(new AthletesByScoreDescSorter());

        ListIterator<Athlete> it = athletes.listIterator();
        List<Athlete> athletesRatedBefore = new ArrayList<>();

        Integer initialPlace = 1;

        Athlete left = it.next();
        left.getResult().setPlace(initialPlace.toString());

        while (it.hasNext()) {
            Athlete right = it.next();
            String currPlace = (++initialPlace).toString();
            if (!left.getResult().getScore().equals(right.getResult().getScore())) {
                right.getResult().setPlace(currPlace);
                athletesRatedBefore.clear();
            } else {
                currPlace = left.getResult().getPlace() + "-" + currPlace;
                left.getResult().setPlace(currPlace);
                right.getResult().setPlace(currPlace);

                for (Athlete athlete : athletesRatedBefore) {
                    athlete.getResult().setPlace(currPlace);
                }

                athletesRatedBefore.add(left);
            }
            left = right;
        }
    }
}
