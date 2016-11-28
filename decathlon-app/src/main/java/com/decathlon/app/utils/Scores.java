package com.decathlon.app.utils;
/**
 * Enum providing constants, used to evaluate each event of Decathlon
 * competition. There are three constants on each event: A, B and C.
 *
 * @author redaz
 */
public enum Scores {
    /**
     * Constants for '100 m' running event.
     */
    SHORT_RUN_A(25.4347),
    SHORT_RUN_B(18),
    SHORT_RUN_C(1.81),
    /**
     * Constants for 'Long Jump' event.
     */
    LONG_JUMP_A(0.14354),
    LONG_JUMP_B(220),
    LONG_JUMP_C(1.4),
    /**
     * Constants for 'Shot Put' event.
     */
    SHOT_PUT_A(51.39),
    SHOT_PUT_B(1.5),
    SHOT_PUT_C(1.05),
    /**
     * Constants for 'High Jump' event.
     */
    HIGH_JUMP_A(0.8465),
    HIGH_JUMP_B(75),
    HIGH_JUMP_C(1.42),
    /**
     * Constants for '400 m' running event.
     */
    MIDDLE_RUN_A(1.53775),
    MIDDLE_RUN_B(82),
    MIDDLE_RUN_C(1.81),
    /**
     * Constants for '110 m' for men and '100 m' for women running event.
     */
    SHORT_RUN_HARDLES_A(5.74352),
    SHORT_RUN_HARDLES_B(28.5),
    SHORT_RUN_HARDLES_C(1.92),
    /**
     * Constants for 'Discus Throw' event.
     */
    DISCUS_THROW_A(12.91),
    DISCUS_THROW_B(4),
    DISCUS_THROW_C(1.1),
    /**
     * Constants for 'Pole Vault' event.
     */
    POLE_VAULT_A(0.2797),
    POLE_VAULT_B(100),
    POLE_VAULT_C(1.35),
    /**
     * Constants for 'Javelin Throw' event.
     */
    JAVELIN_THROW_A(10.14),
    JAVELIN_THROW_B(7),
    JAVELIN_THROW_C(1.08),
    /**
     * Constants for '1'500 m' running event.
     */
    LONG_RUN_A(0.03768),
    LONG_RUN_B(480),
    LONG_RUN_C(1.85);

    private double value;

    Scores(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
}
