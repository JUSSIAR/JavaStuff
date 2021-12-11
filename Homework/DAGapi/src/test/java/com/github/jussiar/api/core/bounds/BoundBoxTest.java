package com.github.jussiar.api.core.bounds;

import com.github.jussiar.api.core.coordinates.Coord2D;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundBoxTest {
    private final Coord2D pos = new Coord2D(1.1, 2.2);
    private BoundBox instance;
    private BoundBox instanceFixed;

    @BeforeEach
    void setUp() {
        instance = new BoundBox();
        instanceFixed = new BoundBox(pos);
    }

    @AfterEach
    void tearDown() {
        instance = null;
        instanceFixed = null;
    }

    @Test
    void refresh() {
        assertEquals(instanceFixed.getMinPosition(), pos);
        instanceFixed.refresh();
        assertEquals(instanceFixed.getMinPosition(), Coord2D.createMax());
    }

    @Test
    void tryUpdate() {
        assertEquals(instance.getMinPosition(), Coord2D.createMax());
        assertEquals(instance.getMaxPosition(), Coord2D.createMin());

        instance.tryUpdate(new Coord2D(1.4, 6.6));
        assertEquals(instance.getMinPosition(), new Coord2D(1.4, 6.6));
        assertEquals(instance.getMaxPosition(), new Coord2D(1.4, 6.6));

        instance.tryUpdate(new Coord2D(2.69, 7.77));
        assertEquals(instance.getMinPosition(), new Coord2D(1.4, 6.6));
        assertEquals(instance.getMaxPosition(), new Coord2D(2.69, 7.77));

        instance.tryUpdate(new Coord2D(0.111, 98.0));
        assertEquals(instance.getMinPosition(), new Coord2D(0.111, 6.6));
        assertEquals(instance.getMaxPosition(), new Coord2D(2.69, 98.0));
    }

    @Test
    void getMinPosition() {
        assertEquals(instanceFixed.getMinPosition(), pos);
    }

    @Test
    void getMaxPosition() {
        assertEquals(instanceFixed.getMaxPosition(), pos);
    }

    @Test
    void testToString() {
        assertEquals(instance.toString(), "fullSpace");

        Coord2D pos1 = new Coord2D(1.178, 2.272);
        Coord2D pos2 = new Coord2D(5.5, 1.145);

        instance.tryUpdate(pos1);
        instance.tryUpdate(pos2);

        String string = "{x:[1.18,5.50], y:[1.15,2.27]}";
        assertEquals(instance.toString(), string);
    }
}