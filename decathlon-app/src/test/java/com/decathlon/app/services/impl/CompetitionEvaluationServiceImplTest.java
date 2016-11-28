package com.decathlon.app.services.impl;

import static com.decathlon.app.utils.ScoresUtils.DECATHLON_POINTS;
import static com.decathlon.app.utils.ScoresUtils.DISCUS_THROW;
import static com.decathlon.app.utils.ScoresUtils.DISCUS_THROW_A;
import static com.decathlon.app.utils.ScoresUtils.DISCUS_THROW_B;
import static com.decathlon.app.utils.ScoresUtils.DISCUS_THROW_C;
import static com.decathlon.app.utils.ScoresUtils.DISCUS_THROW_RESULT;
import static com.decathlon.app.utils.ScoresUtils.HIGH_JUMP;
import static com.decathlon.app.utils.ScoresUtils.HIGH_JUMP_A;
import static com.decathlon.app.utils.ScoresUtils.HIGH_JUMP_B;
import static com.decathlon.app.utils.ScoresUtils.HIGH_JUMP_C;
import static com.decathlon.app.utils.ScoresUtils.HIGH_JUMP_RESULT;
import static com.decathlon.app.utils.ScoresUtils.JAVELIN_THROW;
import static com.decathlon.app.utils.ScoresUtils.JAVELIN_THROW_A;
import static com.decathlon.app.utils.ScoresUtils.JAVELIN_THROW_B;
import static com.decathlon.app.utils.ScoresUtils.JAVELIN_THROW_C;
import static com.decathlon.app.utils.ScoresUtils.JAVELIN_THROW_RESULT;
import static com.decathlon.app.utils.ScoresUtils.LONG_JUMP;
import static com.decathlon.app.utils.ScoresUtils.LONG_JUMP_A;
import static com.decathlon.app.utils.ScoresUtils.LONG_JUMP_B;
import static com.decathlon.app.utils.ScoresUtils.LONG_JUMP_C;
import static com.decathlon.app.utils.ScoresUtils.LONG_JUMP_RESULT;
import static com.decathlon.app.utils.ScoresUtils.LONG_RUN;
import static com.decathlon.app.utils.ScoresUtils.LONG_RUN_A;
import static com.decathlon.app.utils.ScoresUtils.LONG_RUN_B;
import static com.decathlon.app.utils.ScoresUtils.LONG_RUN_C;
import static com.decathlon.app.utils.ScoresUtils.LONG_RUN_RESULT;
import static com.decathlon.app.utils.ScoresUtils.MIDDLE_RUN;
import static com.decathlon.app.utils.ScoresUtils.MIDDLE_RUN_A;
import static com.decathlon.app.utils.ScoresUtils.MIDDLE_RUN_B;
import static com.decathlon.app.utils.ScoresUtils.MIDDLE_RUN_C;
import static com.decathlon.app.utils.ScoresUtils.MIDDLE_RUN_RESULT;
import static com.decathlon.app.utils.ScoresUtils.POLE_VAULT;
import static com.decathlon.app.utils.ScoresUtils.POLE_VAULT_A;
import static com.decathlon.app.utils.ScoresUtils.POLE_VAULT_B;
import static com.decathlon.app.utils.ScoresUtils.POLE_VAULT_C;
import static com.decathlon.app.utils.ScoresUtils.POLE_VAULT_RESULT;
import static com.decathlon.app.utils.ScoresUtils.SHORT_RUN;
import static com.decathlon.app.utils.ScoresUtils.SHORT_RUN_A;
import static com.decathlon.app.utils.ScoresUtils.SHORT_RUN_B;
import static com.decathlon.app.utils.ScoresUtils.SHORT_RUN_C;
import static com.decathlon.app.utils.ScoresUtils.SHORT_RUN_HARDLES;
import static com.decathlon.app.utils.ScoresUtils.SHORT_RUN_HARDLES_A;
import static com.decathlon.app.utils.ScoresUtils.SHORT_RUN_HARDLES_B;
import static com.decathlon.app.utils.ScoresUtils.SHORT_RUN_HARDLES_C;
import static com.decathlon.app.utils.ScoresUtils.SHORT_RUN_HARDLES_RESULT;
import static com.decathlon.app.utils.ScoresUtils.SHORT_RUN_RESULT;
import static com.decathlon.app.utils.ScoresUtils.SHOT_PUT;
import static com.decathlon.app.utils.ScoresUtils.SHOT_PUT_A;
import static com.decathlon.app.utils.ScoresUtils.SHOT_PUT_B;
import static com.decathlon.app.utils.ScoresUtils.SHOT_PUT_C;
import static com.decathlon.app.utils.ScoresUtils.SHOT_PUT_RESULT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.decathlon.app.domain.PartyDTO;
import com.decathlon.app.domain.PartyNameDTO;
import com.decathlon.app.domain.ScoresDTO;
import com.decathlon.app.services.ScoresCounterService;

/**
 * Unit tests for {@link CompetitionEvaluationServiceImpl}.
 * <p>
 * To ensure, that calculations are correct, unit tests are based on real data
 * of Roman Šebrle. More information:
 * https://www.usatf.org/statistics/calculators/combinedEventsScoring.
 *
 * @author redaz
 */
public class CompetitionEvaluationServiceImplTest {

    private CompetitionEvaluationServiceImpl service;

    @Mock private ScoresCounterService scoresCounterService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new CompetitionEvaluationServiceImpl();
        service.setScoresCounterService(scoresCounterService);
    }

    @Test
    public void shouldEvaluateCompetition() {
        // given
        PartyDTO party = createPartyDTO();

        given(scoresCounterService.evaluateTrackEvent(SHORT_RUN, SHORT_RUN_A, SHORT_RUN_B, SHORT_RUN_C)).willReturn(SHORT_RUN_RESULT);
        given(scoresCounterService.evaluateTrackEvent(SHORT_RUN_HARDLES, SHORT_RUN_HARDLES_A, SHORT_RUN_HARDLES_B, SHORT_RUN_HARDLES_C)).willReturn(SHORT_RUN_HARDLES_RESULT);
        given(scoresCounterService.evaluateTrackEvent(MIDDLE_RUN, MIDDLE_RUN_A, MIDDLE_RUN_B, MIDDLE_RUN_C)).willReturn(MIDDLE_RUN_RESULT);
        given(scoresCounterService.evaluateTrackEvent(LONG_RUN, LONG_RUN_A, LONG_RUN_B, LONG_RUN_C)).willReturn(LONG_RUN_RESULT);
        given(scoresCounterService.evaluateFieldEvent(HIGH_JUMP, HIGH_JUMP_A, HIGH_JUMP_B, HIGH_JUMP_C)).willReturn(HIGH_JUMP_RESULT);
        given(scoresCounterService.evaluateFieldEvent(LONG_JUMP, LONG_JUMP_A, LONG_JUMP_B, LONG_JUMP_C)).willReturn(LONG_JUMP_RESULT);
        given(scoresCounterService.evaluateFieldEvent(POLE_VAULT, POLE_VAULT_A, POLE_VAULT_B, POLE_VAULT_C)).willReturn(POLE_VAULT_RESULT);
        given(scoresCounterService.evaluateFieldEvent(SHOT_PUT, SHOT_PUT_A, SHOT_PUT_B, SHOT_PUT_C)).willReturn(SHOT_PUT_RESULT);
        given(scoresCounterService.evaluateFieldEvent(DISCUS_THROW, DISCUS_THROW_A, DISCUS_THROW_B, DISCUS_THROW_C)).willReturn(DISCUS_THROW_RESULT);
        given(scoresCounterService.evaluateFieldEvent(JAVELIN_THROW, JAVELIN_THROW_A, JAVELIN_THROW_B, JAVELIN_THROW_C)).willReturn(JAVELIN_THROW_RESULT);

        // when
        int points = service.evaluateCompetition(party);

        // then
        assertThat("Incorrect Decathlon result", points, equalTo(DECATHLON_POINTS));
    }

    private PartyDTO createPartyDTO() {
        PartyDTO party = new PartyDTO();
        party.setPartyName(createPartyNameDTO());
        party.setScores(createScoresDTO());
        return party;
    }

    private PartyNameDTO createPartyNameDTO() {
        return new PartyNameDTO("Roman", "Šebrle");
    }

    private ScoresDTO createScoresDTO() {
        return new ScoresDTO(SHORT_RUN, 8.11, SHOT_PUT, 2.15, MIDDLE_RUN, SHORT_RUN_HARDLES, DISCUS_THROW, 5.2, JAVELIN_THROW, "4.21.98");
    }
}
