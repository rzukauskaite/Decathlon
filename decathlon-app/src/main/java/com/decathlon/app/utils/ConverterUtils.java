package com.decathlon.app.utils;

import java.text.MessageFormat;

import org.springframework.util.Assert;


/**
 * Utils class providing custom conversion methods.
 *
 * @author redaz
 */
public class ConverterUtils {
    /**
     * Converts {@link String} parameter to a {@link Double}.
     * <p>
     * <b>Note:</b> if passed parameter cannot be converted to a double - exception is thrown.
     * @param doubleAsString
     * @return double value of the parameter
     */
    public static double convertToDouble(String doubleAsString) {
        Assert.notNull(doubleAsString, "Parameter 'doubleValueAsString' cannot be null");
        try {
            return Double.parseDouble(doubleAsString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(MessageFormat.format("Parameter {0} cannot be converted to double", doubleAsString));
        }
    }
}
