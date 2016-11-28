package com.decathlon.app.services;

import com.decathlon.app.domain.PartyDTO;
/**
 * Service to evaluate each contestant.
 *
 * @author redaz
 */
public interface CompetitionEvaluationService {
    /**
     * Counts each Decathlon competition event results and evaluates contestant.
     * <p>
     * <b>Note:</b> final points consists of points sum, earned on each event.
     *
     * @param party contestant data, who's competition results should be calculated
     * @return total points of Decathlon competition
     */
    public int evaluateCompetition(PartyDTO party);
}
