package com.decathlon.app.services.impl;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.decathlon.app.services.ScoresCounterService;
import com.decathlon.app.utils.Scores;
/**
 * Implementation for {@link ScoresCounterService}.
 *
 * @author redaz
 */
public class ScoresCounterServiceImpl implements ScoresCounterService {

    private static final Logger LOG = LoggerFactory.getLogger(ScoresCounterServiceImpl.class);

    /**
     * {@inheritDoc}
     */
    public int evaluateTrackEvent(double performance, double constantA, double constantB, double constantC) {
        LOG.trace(MessageFormat.format("[evaluateTrackEvent] event evaluation started: P={0}, A={1}, B={2}, C={3}",
                performance, constantA, constantB, constantC));

        double ground = constantB - performance;
        return evaluateEvent(constantA, constantC, ground);
    }

    /**
     * {@inheritDoc}
     */
    public int evaluateFieldEvent(double performance, double constantA, double constantB, double constantC) {
        LOG.trace(MessageFormat.format("[evaluateFieldEvent] event evaluation started: P={0}, A={1}, B={2}, C={3}",
                performance, constantA, constantB, constantC));

        double ground = performance - constantB;
        return evaluateEvent(constantA, constantC, ground);
    }

    /**
     * Counts points.
     *
     * @param constantA parameter that vary by discipline, stored in {@link Scores}
     * @param constantC parameter that vary by discipline, stored in {@link Scores}. It's a power index
     * @param ground by different formula calculated result, which should be raised to a power
     * @return points, achieved for event
     */
    protected int evaluateEvent(double constantA, double constantC, double ground) {
        if (ground < 0) {
            ground *= (-1);
        }

        int points = (int) (constantA * Math.pow(ground, constantC));
        LOG.trace(MessageFormat.format("[evaluateEvent] event points: {0}", points));

        return points;
    }

}
