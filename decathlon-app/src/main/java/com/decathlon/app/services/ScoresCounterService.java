package com.decathlon.app.services;

import com.decathlon.app.utils.Scores;

/**
 * Service to count points for each event.
 *
 * @author redaz
 */
public interface ScoresCounterService {

    /**
     * Counts points by following formula: A*(B — P)^C for track events (faster
     * time produces a better score). A, B and C are parameters that vary by
     * discipline, while P is the performance by the athlete, measured in
     * seconds (running), meters (throwing), or centimeters (jumping).
     * <p>
     * <b>Note:</b> for Running Events.
     *
     * @param performance performance by the athlete
     * @param constantA parameter that vary by discipline, stored in {@link Scores}
     * @param constantB parameter that vary by discipline, stored in {@link Scores}
     * @param constantC parameter that vary by discipline, stored in {@link Scores}
     * @return points, achieved for event
     */
    public int evaluateTrackEvent(double performance, double constantA, double constantB, double constantC);

    /**
     * Counts points by following formula: A*(P — B)^C for field events (greater
     * distance or height produces a better score). A, B and C are parameters
     * that vary by discipline, while P is the performance by the athlete,
     * measured in seconds (running), meters (throwing), or centimeters
     * (jumping).
     * <p>
     * <b>Note:</b> for Field Events.
     *
     * @param performance performance by the athlete
     * @param constantA parameter that vary by discipline, stored in {@link Scores}
     * @param constantB parameter that vary by discipline, stored in {@link Scores}
     * @param constantC parameter that vary by discipline, stored in {@link Scores}
     * @return points, achieved for event
     */
    public int evaluateFieldEvent(double performance, double constantA, double constantB, double constantC);
}
