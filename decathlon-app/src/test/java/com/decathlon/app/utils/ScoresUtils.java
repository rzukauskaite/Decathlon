package com.decathlon.app.utils;

/**
 * Utils class for Unit tests. This class holds information (real data) of Roman
 * 各brle performance on each Decathlon competition event. Also, this utils
 * class holds constants, used to evaluate each event scores.
 *
 * @author redaz
 */
public class ScoresUtils {
    /**
     * Constants for '100 m' running event.
     */
    public static final double SHORT_RUN_A = 25.4347;
    public static final double SHORT_RUN_B = 18;
    public static final double SHORT_RUN_C = 1.81;
    /**
     * Constants for 'Long Jump' event.
     */
    public static final double LONG_JUMP_A = 0.14354;
    public static final double LONG_JUMP_B = 220;
    public static final double LONG_JUMP_C = 1.4;
    /**
     * Constants for 'Shot Put' event.
     */
    public static final double SHOT_PUT_A = 51.39;
    public static final double SHOT_PUT_B = 1.5;
    public static final double SHOT_PUT_C = 1.05;
    /**
     * Constants for 'High Jump' event.
     */
    public static final double HIGH_JUMP_A = 0.8465;
    public static final double HIGH_JUMP_B = 75;
    public static final double HIGH_JUMP_C = 1.42;
    /**
     * Constants for '400 m' running event.
     */
    public static final double MIDDLE_RUN_A = 1.53775;
    public static final double MIDDLE_RUN_B = 82;
    public static final double MIDDLE_RUN_C = 1.81;
    /**
     * Constants for '110 m' for men and '100 m' for women running event.
     */
    public static final double SHORT_RUN_HARDLES_A = 5.74352;
    public static final double SHORT_RUN_HARDLES_B = 28.5;
    public static final double SHORT_RUN_HARDLES_C = 1.92;
    /**
     * Constants for 'Discus Throw' event.
     */
    public static final double DISCUS_THROW_A = 12.91;
    public static final double DISCUS_THROW_B = 4;
    public static final double DISCUS_THROW_C = 1.1;
    /**
     * Constants for 'Pole Vault' event.
     */
    public static final double POLE_VAULT_A = 0.2797;
    public static final double POLE_VAULT_B = 100;
    public static final double POLE_VAULT_C = 1.35;
    /**
     * Constants for 'Javelin Throw' event.
     */
    public static final double JAVELIN_THROW_A = 10.14;
    public static final double JAVELIN_THROW_B = 7;
    public static final double JAVELIN_THROW_C = 1.08;
    /**
     * Constants for '1'500 m' running event.
     */
    public static final double LONG_RUN_A = 0.03768;
    public static final double LONG_RUN_B = 480;
    public static final double LONG_RUN_C = 1.85;

    /**
     * Roman 各brle performance on each event.
     */
    public static final double SHORT_RUN = 10.64;
    public static final double MIDDLE_RUN = 47.76;
    /*
     * 4:21.98 is mm:ss.ss to seconds will be 261.98
     */
    public static final double LONG_RUN = 261.98;
    public static final double SHORT_RUN_HARDLES = 13.68;
    /*
     * 2.15 is m.cm to centimeters will be 215
     */
    public static final double HIGH_JUMP = 215;
    /*
     * 5.20 is m.cm to centimeters will be 520
     */
    public static final double POLE_VAULT = 520;
    /*
     * 8.11 is m.cm to centimeters will be 811
     */
    public static final double LONG_JUMP = 811;
    public static final double SHOT_PUT = 16.47;
    public static final double DISCUS_THROW = 49.46;
    public static final double JAVELIN_THROW = 71.18;

    /**
     * Roman 各brle results for each event.
     */
    public static final int SHORT_RUN_RESULT = 942;
    public static final int MIDDLE_RUN_RESULT = 921;
    public static final int LONG_RUN_RESULT = 798;
    public static final int SHORT_RUN_HARDLES_RESULT = 1016;
    public static final int HIGH_JUMP_RESULT = 944;
    public static final int POLE_VAULT_RESULT = 972;
    public static final int LONG_JUMP_RESULT = 1089;
    public static final int SHOT_PUT_RESULT = 880;
    public static final int DISCUS_THROW_RESULT = 859;
    public static final int JAVELIN_THROW_RESULT = 907;

    /**
     * Roman 各brle final result for Decathlon competition.
     */
    public static final int DECATHLON_POINTS = 9328;
}
