package com.github.jussiar.api.core.nodes.point;

import com.github.jussiar.api.core.coordinates.Coord2D;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    private final Coord2D pos = new Coord2D(1.1, 2.2);
    private Point instance;
    private Point instanceFixed;

    @BeforeEach
    void setUp() {
        instance = new Point();
        instanceFixed = new Point(pos);
    }

    @AfterEach
    void tearDown() {
        instance = null;
        instanceFixed = null;
    }

    @Test
    void getPosition() {
        assertEquals(instanceFixed.getPosition(), pos);
    }

    @Test
    void setPosition() {
        instance.setPosition(pos);
        assertEquals(instance.getPosition(), pos);
    }

    @Test
    void getBounds() {
        Coord2D otherPos = new Coord2D(8.8, 9.9);
        instance.setPosition(otherPos);
        assertEquals(instanceFixed.getBounds().getMinPosition(), pos);
        assertEquals(instance.getBounds().getMaxPosition(), otherPos);
    }

    @Test
    void testToString() {
        Coord2D otherPos = new Coord2D(1.239, 4.5);
        instance.setPosition(otherPos);
        String string =
                "{\n" +
                "  type:Origin,\n" +
                "  position:{x:1.24, y:4.50},\n" +
                "}";
        assertEquals(instance.toString(), string);
    }
}