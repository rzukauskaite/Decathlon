package com.decathlon.app.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * DTO to carry competition results, i.e.: points earned on each event.
 *
 * @author redaz
 */
public class ScoresDTO {

    /**
     * Time, person has run the distance of 100 meters. Measured by seconds.
     */
    private double shortRun;
    /**
     * Distance, person has jumped. Measured by meters.
     * <p>
     * <b>Note:</b> Track and field event involving leaping as far as possible.
     */
    private double longJump;
    /**
     * Distance, person has thrown the shot. Measured by meters.
     * <p>
     * <b>Note:</b> Track and field event involving "throwing"/"putting" a heavy
     * spherical object as far as possible.
     */
    private double shotPut;
    /**
     * High, person has jumped. Measured by meters.
     * <p>
     * <b>Note:</b> Track and field event in which competitors must jump unaided
     * over a horizontal bar placed at measured heights without dislodging it.
     */
    private double highJump;
    /**
     * Time, person has run the distance of 400 meters. Measured by seconds.
     */
    private double middleRun;
    /**
     * Time, person has run the distance. Measured by seconds.
     * <p>
     * <b>Note:</b> Track and field event for men of 110 meters hurdles. The
     * female - 100 meters hurdles.
     */
    private double shortRunHurdles;
    /**
     * Distance, person has thrown the disc. Measured by meters.
     * <p>
     * <b>Note:</b> Track and field event in which an athlete throws a heavy
     * disc in an attempt to mark a farther distance than their competitors.
     */
    private double discusThrow;
    /**
     * Distance, person has jumped using pole. Measured by meters.
     * <p>
     * <b>Note:</b> Track and field event in which a person uses a long,
     * flexible pole as an aid to jump over a bar.
     */
    private double poleVault;
    /**
     * Distance, person has thrown the javelin. Measured by meters.
     * <p>
     * <b>Note:</b> Track and field event where the javelin, a spear about 2.5 m
     * (8 ft 2 in) in length, is thrown.
     */
    private double javelinThrow;
    /**
     * Indicates a running distance of 1500 meters. Measured by seconds.
     */
    private double longRun;

    public ScoresDTO() { }

    public ScoresDTO(double shortRun, double longJump, double shotPut, double highJump, double middleRun,
            double shortRunHurdles, double discusThrow, double poleVault, double javelinThrow,
            String longRun) {
        super();
        this.shortRun = shortRun;
        this.longJump = toCentimeters(longJump);
        this.shotPut = shotPut;
        this.highJump = toCentimeters(highJump);
        this.middleRun = middleRun;
        this.shortRunHurdles = shortRunHurdles;
        this.discusThrow = discusThrow;
        this.poleVault = toCentimeters(poleVault);
        this.javelinThrow = javelinThrow;
        this.longRun = toSeconds(longRun);
    }

    /**
     * Calculates numeric value (measured in seconds) from display value of
     * following format: mm.ss.ss. To convert to seconds, following formula
     * applied: mm*60 + ss.ss
     * 
     * @param longRun long run display value, that should be resolved
     * @return long run value, converted to seconds
     */
    protected double toSeconds(String value) {
        return Double.parseDouble(value.substring(0, value.indexOf("."))) * 60
                + Double.parseDouble(value.substring(value.indexOf(".")+1));
    }

    /**
     * Converts meters to centimeters. Value comes in following format: m.cm. To
     * convert to centimeters, following formula applied: m*100 + cm.
     *
     * @param value value in meters
     * @return value in centimeters
     */
    protected double toCentimeters(double value) {
        BigDecimal number = new BigDecimal(String.valueOf(value)).setScale(2);
        BigDecimal decimal = number.subtract(number.setScale(0, RoundingMode.FLOOR)).movePointRight(number.scale());
        return number.intValue() * 100 + decimal.doubleValue();
    }

    public double getShortRun() {
        return shortRun;
    }
    public void setShortRun(double shortRun) {
        this.shortRun = shortRun;
    }
    public double getLongJump() {
        return longJump;
    }
    public void setLongJump(double longJump) {
        this.longJump = longJump;
    }
    public double getShotPut() {
        return shotPut;
    }
    public void setShotPut(double shotPut) {
        this.shotPut = shotPut;
    }
    public double getHighJump() {
        return highJump;
    }
    public void setHighJump(double highJump) {
        this.highJump = highJump;
    }
    public double getMiddleRun() {
        return middleRun;
    }
    public void setMiddleRun(double middleRun) {
        this.middleRun = middleRun;
    }
    public double getShortRunHurdles() {
        return shortRunHurdles;
    }
    public void setShortRunHurdles(double shortRunHurdles) {
        this.shortRunHurdles = shortRunHurdles;
    }
    public double getDiscusThrow() {
        return discusThrow;
    }
    public void setDiscusThrow(double discusThrow) {
        this.discusThrow = discusThrow;
    }
    public double getPoleVault() {
        return poleVault;
    }
    public void setPoleVault(double poleVault) {
        this.poleVault = poleVault;
    }
    public double getJavelinThrow() {
        return javelinThrow;
    }
    public void setJavelinThrow(double javelinThrow) {
        this.javelinThrow = javelinThrow;
    }
    public double getLongRun() {
        return longRun;
    }
    public void setLongRun(double longRun) {
        this.longRun = longRun;
    }
}
