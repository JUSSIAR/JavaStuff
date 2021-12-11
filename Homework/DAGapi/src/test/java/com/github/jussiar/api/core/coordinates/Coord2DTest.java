package com.github.jussiar.api.core.coordinates;

import com.github.jussiar.api.utils.format.FormatDouble;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Coord2DTest {
    private final double x = 1.116;
    private final double y = -56.333;
    private final Coord2D instance = new Coord2D(x, y);

    @Test
    void createDefault() {
        assertEquals(Coord2D.createDefault().x(), 0.0, FormatDouble.eps);
    }

    @Test
    void createMin() {
        assertEquals(Coord2D.createMin().x(), Double.MIN_VALUE, FormatDouble.eps);
    }

    @Test
    void createMax() {
        assertEquals(Coord2D.createMax().y(), Double.MAX_VALUE, FormatDouble.eps);
    }

    @Test
    void testToString() {
        assertEquals(instance.toString(), "{x:1.12, y:-56.33}");
    }

    @Test
    void x() {
        assertEquals(instance.x(), x, FormatDouble.eps);
    }

    @Test
    void y() {
        assertEquals(instance.y(), y, FormatDouble.eps);
    }
}