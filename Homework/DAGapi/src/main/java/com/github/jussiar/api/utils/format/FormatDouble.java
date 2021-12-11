package com.github.jussiar.api.utils.format;

import java.text.DecimalFormat;

/**
 * Node interface
 * @author Klokov Stas 201
 * @version 1.0.0
 */
public class FormatDouble {
    public static final double eps = 1e-4;

    /**
     * String representation of double in case.
     * @param number double value.
     * @return string value.
     */
    public static String format(double number) {
        return new DecimalFormat("#.00")
                .format(number)
                .replace(',', '.');
    }
}
