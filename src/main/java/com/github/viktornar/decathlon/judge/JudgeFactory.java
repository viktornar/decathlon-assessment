package com.github.viktornar.decathlon.judge;

import com.github.viktornar.decathlon.accessor.Assessor;
import com.github.viktornar.decathlon.accessor.DecathlonAssessor;
import com.github.viktornar.decathlon.decoder.Decoder;
import com.github.viktornar.decathlon.decoder.GenericDecoder;
import com.github.viktornar.decathlon.encoder.Encoder;
import com.github.viktornar.decathlon.encoder.GenericEncoder;

/**
 * JudgeFactory allows to initialize Judge class with different types of
 * data encoders and decoders
 *
 * @author v.nareiko
 */
public class JudgeFactory {
    /**
     * Creates Judge by given type of encoder and decoder
     * @param decoderType - decoder type e.g. CSV, XML. CSV only implemented
     * @param encoderType - decoder type e.g. CSV, XML. XML only implemented
     * @return - Judge to make verdict on athletes
     */
    public Judge createJudge(String decoderType, String encoderType) {
        Decoder decoder = new GenericDecoder(decoderType);
        Encoder encoder = new GenericEncoder(encoderType);
        Assessor assessor = new DecathlonAssessor();
        return new Judge(encoder, decoder, assessor);
    }
}
