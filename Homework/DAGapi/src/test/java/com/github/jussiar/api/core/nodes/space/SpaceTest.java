package com.github.jussiar.api.core.nodes.space;

import com.github.jussiar.api.core.coordinates.Coord2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {
    @Test
    void testInfo() {
        assertNotEquals(Space.info, "");
    }

    @Test
    void testToString() {
        Space instance = new Space();
        instance.setPosition(new Coord2D(1.1, 2.222));

        String string =
                "{\n" +
                "  type:Space,\n" +
                "  position:{x:1.10, y:2.22},\n" +
                "  bounds:{x:[1.10,1.10], y:[2.22,2.22]},\n" +
                "}";

        assertEquals(instance.toString(), string);
    }
}