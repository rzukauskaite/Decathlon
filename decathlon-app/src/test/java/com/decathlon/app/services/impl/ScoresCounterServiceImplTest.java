package com.decathlon.app.services.impl;
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

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link ScoresCounterServiceImpl}.
 * <p>
 * To ensure, that calculations are correct, unit tests are based on real data
 * of Roman Šebrle. More information:
 * https://www.usatf.org/statistics/calculators/combinedEventsScoring.
 *
 * @author redaz
 */
public class ScoresCounterServiceImplTest {

    private ScoresCounterServiceImpl service;

    @Before
    public void setUp() {
        service = new ScoresCounterServiceImpl();
    }

    @Test
    public void shouldEvaluateShortRunEvent() {
        // when
        int points = service.evaluateTrackEvent(SHORT_RUN, SHORT_RUN_A, SHORT_RUN_B, SHORT_RUN_C);

        // then
        assertThat("Incorrect result for Run Event: 100 m", points, equalTo(SHORT_RUN_RESULT));
    }

    @Test
    public void shouldEvaluateMiddleRunEvent() {
        // when
        int points = service.evaluateTrackEvent(MIDDLE_RUN, MIDDLE_RUN_A, MIDDLE_RUN_B, MIDDLE_RUN_C);

        // then
        assertThat("Incorrect result for Run Event: 400 m", points, equalTo(MIDDLE_RUN_RESULT));
    }

    @Test
    public void shouldEvaluateLongRunEvent() {
        // when
        int points = service.evaluateTrackEvent(LONG_RUN, LONG_RUN_A, LONG_RUN_B, LONG_RUN_C);

        // then
        assertThat("Incorrect result for Long Run Event: run 1'500 m", points, equalTo(LONG_RUN_RESULT));
    }

    @Test
    public void shouldEvaluateShortRunHurdlesEvent() {
        // when
        int points = service.evaluateTrackEvent(SHORT_RUN_HARDLES, SHORT_RUN_HARDLES_A, SHORT_RUN_HARDLES_B,
                SHORT_RUN_HARDLES_C);

        // then
        assertThat("Incorrect result for Run Hardles Event: 110 m (for men) or 100 m (for women)", points,
                equalTo(SHORT_RUN_HARDLES_RESULT));
    }

    @Test
    public void shouldEvaluateHighJumpEvent() {
        // when
        int points = service.evaluateFieldEvent(HIGH_JUMP, HIGH_JUMP_A, HIGH_JUMP_B, HIGH_JUMP_C);

        // then
        assertThat("Incorrect result for High Jump Event", points, equalTo(HIGH_JUMP_RESULT));
    }

    @Test
    public void shouldEvaluateLongJumpEvent() {
        // when
        int points = service.evaluateFieldEvent(LONG_JUMP, LONG_JUMP_A, LONG_JUMP_B, LONG_JUMP_C);

        // then
        assertThat("Incorrect result for Long Jump Event", points, equalTo(LONG_JUMP_RESULT));
    }

    @Test
    public void shouldEvaluatePoleVaultEvent() {
        // when
        int points = service.evaluateFieldEvent(POLE_VAULT, POLE_VAULT_A, POLE_VAULT_B, POLE_VAULT_C);

        // then
        assertThat("Incorrect result for Pole Vault Event", points, equalTo(POLE_VAULT_RESULT));
    }

    @Test
    public void shouldEvaluateShotPutEvent() {
        // when
        int points = service.evaluateFieldEvent(SHOT_PUT, SHOT_PUT_A, SHOT_PUT_B, SHOT_PUT_C);

        // then
        assertThat("Incorrect result for Shot Put Event", points, equalTo(SHOT_PUT_RESULT));
    }

    @Test
    public void shouldEvaluateDiscusTrowEvent() {
        // when
        int points = service.evaluateFieldEvent(DISCUS_THROW, DISCUS_THROW_A, DISCUS_THROW_B, DISCUS_THROW_C);

        // then
        assertThat("Incorrect result for Discus Trow Event", points, equalTo(DISCUS_THROW_RESULT));
    }

    @Test
    public void shouldEvaluateJavelinTrowEvent() {
        // when
        int points = service.evaluateFieldEvent(JAVELIN_THROW, JAVELIN_THROW_A, JAVELIN_THROW_B, JAVELIN_THROW_C);

        // then
        assertThat("Incorrect result for Javelin Throw Event", points, equalTo(JAVELIN_THROW_RESULT));
    }
}
