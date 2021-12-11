package com.github.jussiar.api.core.coordinates;

import com.github.jussiar.api.utils.format.FormatDouble;

/**
 * Coordinates on plane
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see FormatDouble
 */
public record Coord2D(
        double x,
        double y
) {
    /**
     * Provides default coordinates.
     * @return coordinate.
     */
    public static Coord2D createDefault() {
        return new Coord2D(0.0, 0.0);
    }

    /**
     * Provides min coordinates.
     * @return coordinate.
     */
    public static Coord2D createMin() {
        return new Coord2D(Double.MIN_VALUE, Double.MIN_VALUE);
    }

    /**
     * Provides mix coordinates.
     * @return coordinate.
     */
    public static Coord2D createMax() {
        return new Coord2D(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    /**
     * Provides string representation.
     * @return string.
     */
    public String toString() {
        return "{x:" + FormatDouble.format(x()) + ", y:" + FormatDouble.format(y()) + "}";
    }
}
