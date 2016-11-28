package com.decathlon.app.services.impl;

import static com.decathlon.app.utils.Scores.DISCUS_THROW_A;
import static com.decathlon.app.utils.Scores.DISCUS_THROW_B;
import static com.decathlon.app.utils.Scores.DISCUS_THROW_C;
import static com.decathlon.app.utils.Scores.HIGH_JUMP_A;
import static com.decathlon.app.utils.Scores.HIGH_JUMP_B;
import static com.decathlon.app.utils.Scores.HIGH_JUMP_C;
import static com.decathlon.app.utils.Scores.JAVELIN_THROW_A;
import static com.decathlon.app.utils.Scores.JAVELIN_THROW_B;
import static com.decathlon.app.utils.Scores.JAVELIN_THROW_C;
import static com.decathlon.app.utils.Scores.LONG_JUMP_A;
import static com.decathlon.app.utils.Scores.LONG_JUMP_B;
import static com.decathlon.app.utils.Scores.LONG_JUMP_C;
import static com.decathlon.app.utils.Scores.LONG_RUN_A;
import static com.decathlon.app.utils.Scores.LONG_RUN_B;
import static com.decathlon.app.utils.Scores.LONG_RUN_C;
import static com.decathlon.app.utils.Scores.MIDDLE_RUN_A;
import static com.decathlon.app.utils.Scores.MIDDLE_RUN_B;
import static com.decathlon.app.utils.Scores.MIDDLE_RUN_C;
import static com.decathlon.app.utils.Scores.POLE_VAULT_A;
import static com.decathlon.app.utils.Scores.POLE_VAULT_B;
import static com.decathlon.app.utils.Scores.POLE_VAULT_C;
import static com.decathlon.app.utils.Scores.SHORT_RUN_A;
import static com.decathlon.app.utils.Scores.SHORT_RUN_B;
import static com.decathlon.app.utils.Scores.SHORT_RUN_C;
import static com.decathlon.app.utils.Scores.SHORT_RUN_HARDLES_A;
import static com.decathlon.app.utils.Scores.SHORT_RUN_HARDLES_B;
import static com.decathlon.app.utils.Scores.SHORT_RUN_HARDLES_C;
import static com.decathlon.app.utils.Scores.SHOT_PUT_A;
import static com.decathlon.app.utils.Scores.SHOT_PUT_B;
import static com.decathlon.app.utils.Scores.SHOT_PUT_C;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.decathlon.app.domain.PartyDTO;
import com.decathlon.app.services.CompetitionEvaluationService;
import com.decathlon.app.services.ScoresCounterService;
/**
 * Implementation for {@link CompetitionEvaluationService}.
 *
 * @author redaz
 */
public class CompetitionEvaluationServiceImpl implements CompetitionEvaluationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompetitionEvaluationServiceImpl.class);

    private ScoresCounterService scoresCounterService;

    /**
     * {@inheritDoc}
     */
    public int evaluateCompetition(PartyDTO party) {
        Assert.notNull(party, "Parameter 'party' cannot be null");
        LOG.debug(MessageFormat.format("[evaluateCompetition] Competition evaluation for {0} started", party.getPartyName().getDisplayName()));

        double shortRunScores = scoresCounterService.evaluateTrackEvent(party.getScores().getShortRun(),
                SHORT_RUN_A.getValue(), SHORT_RUN_B.getValue(), SHORT_RUN_C.getValue());
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon '100 m' running event results: {0}", shortRunScores));

        double shortRunHardlesScores = scoresCounterService.evaluateTrackEvent(party.getScores().getShortRunHurdles(),
                SHORT_RUN_HARDLES_A.getValue(), SHORT_RUN_HARDLES_B.getValue(), SHORT_RUN_HARDLES_C.getValue());
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon '110 m hardles' running event results: {0}", shortRunHardlesScores));

        double middleRunScores = scoresCounterService.evaluateTrackEvent(party.getScores().getMiddleRun(),
                MIDDLE_RUN_A.getValue(), MIDDLE_RUN_B.getValue(), MIDDLE_RUN_C.getValue());
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon '400 m' running event results: {0}", middleRunScores));

        double longRunScores = scoresCounterService.evaluateTrackEvent(party.getScores().getLongRun(),
                LONG_RUN_A.getValue(), LONG_RUN_B.getValue(), LONG_RUN_C.getValue());
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon '1500 m' running event results: {0}", longRunScores));

        double highJumpScores = scoresCounterService.evaluateFieldEvent(party.getScores().getHighJump(),
                HIGH_JUMP_A.getValue(), HIGH_JUMP_B.getValue(), HIGH_JUMP_C.getValue());
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon 'High Jump' event results: {0}", highJumpScores));

        double longJumpScores = scoresCounterService.evaluateFieldEvent(party.getScores().getLongJump(),
                LONG_JUMP_A.getValue(), LONG_JUMP_B.getValue(), LONG_JUMP_C.getValue());
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon 'Long Jump' event results: {0}", longJumpScores));

        double poleVaultScores = scoresCounterService.evaluateFieldEvent(party.getScores().getPoleVault(),
                POLE_VAULT_A.getValue(), POLE_VAULT_B.getValue(), POLE_VAULT_C.getValue());
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon 'Pole Vault' event results: {0}", poleVaultScores));

        double shotPutScores = scoresCounterService.evaluateFieldEvent(party.getScores().getShotPut(),
                SHOT_PUT_A.getValue(), SHOT_PUT_B.getValue(), SHOT_PUT_C.getValue());
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon 'Shot Put' event results: {0}", shotPutScores));

        double discusThrowScores = scoresCounterService.evaluateFieldEvent(party.getScores().getDiscusThrow(),
                DISCUS_THROW_A.getValue(), DISCUS_THROW_B.getValue(), DISCUS_THROW_C.getValue());
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon 'Discus Trow' event results: {0}", discusThrowScores));

        double javelinThrowScores = scoresCounterService.evaluateFieldEvent(party.getScores().getJavelinThrow(),
                JAVELIN_THROW_A.getValue(), JAVELIN_THROW_B.getValue(), JAVELIN_THROW_C.getValue());
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon 'Javelin Trow' event results: {0}", javelinThrowScores));

        int finalPoints = (int) (shortRunScores + shortRunHardlesScores + middleRunScores + longRunScores + highJumpScores
                + longJumpScores + poleVaultScores + shotPutScores + discusThrowScores + javelinThrowScores);
        LOG.debug(MessageFormat.format("[evaluateCompetition] Decathlon competition final points: {0}", finalPoints));

        return finalPoints;
    }

    public ScoresCounterService getScoresCounterService() {
        return scoresCounterService;
    }

    public void setScoresCounterService(ScoresCounterService scoresCounterService) {
        this.scoresCounterService = scoresCounterService;
    }

}
