package com.github.viktornar.decathlon.judge;


import com.github.viktornar.decathlon.accessor.Assessor;
import com.github.viktornar.decathlon.comparator.AthletesByScoreDescSorter;
import com.github.viktornar.decathlon.decoder.Decoder;
import com.github.viktornar.decathlon.encoder.Encoder;
import com.github.viktornar.decathlon.model.Athlete;
import com.github.viktornar.decathlon.model.Competition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Judge class that make verdict about athletes positions (ranks).
 * It is Facade for other classes that do dirty job.
 * Should not be initialize by itself. Use JudgeFactory for initializing
 *
 * @author v.nareiko
 */
public class Judge {
    private Encoder encoder;
    private Decoder decoder;
    private Assessor assessor;

    Judge(Encoder encoder, Decoder decoder, Assessor assessor) {
        this.encoder = encoder;
        this.decoder = decoder;
        this.assessor = assessor;
    }

    /**
     * Make verdict for athletes in given competition
     *
     * @param input - file to read athletes records
     * @param output - file to write verdict
     */
    public void makeVerdict(File input, File output) {
        List<Athlete> athletes = new ArrayList<>();

        athletes = decoder.readData(input);

        if (athletes.size() > 0) {
            assessor.rate(athletes);
            assessor.reward(athletes);

            athletes.sort(new AthletesByScoreDescSorter());
            Competition competition = new Competition();
            competition.setAthletes(athletes);

            encoder.writeData(output, encoder.encode(competition, Competition.class));
        }
    }

    /**
     * Make verdict for athletes in given competition.
     * Verdict will be printed in console
     *
     * @param input - file to read athletes records
     *
     */
    public void makeVerdict(File input) {
        List<Athlete> athletes = new ArrayList<>();

        athletes = decoder.readData(input);

        assessor.rate(athletes);
        assessor.reward(athletes);

        athletes.sort(new AthletesByScoreDescSorter());
        Competition competition = new Competition();
        competition.setAthletes(athletes);

        System.out.println(encoder.encode(competition, Competition.class));
    }
}
