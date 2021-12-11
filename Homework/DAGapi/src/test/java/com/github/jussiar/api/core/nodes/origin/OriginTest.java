package com.github.jussiar.api.core.nodes.origin;

import com.github.jussiar.api.core.bounds.BoundBox;
import com.github.jussiar.api.core.coordinates.Coord2D;
import com.github.jussiar.api.core.nodes.point.Point;
import com.github.jussiar.api.core.nodes.space.Space;
import com.github.jussiar.api.core.nodes.vertex.Vertex;
import com.github.jussiar.api.exceptions.AddSpaceException;
import com.github.jussiar.api.exceptions.CycleException;
import com.github.jussiar.api.exceptions.RemoveNodeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OriginTest {
    private final Coord2D pos = new Coord2D(1.1, 2.2);
    private Origin instance;
    private Origin instanceFixed;

    @BeforeEach
    void setUp() {
        instance = new Origin();
        instanceFixed = new Origin(pos);
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
        instance.setPosition(new Coord2D(1.1, 2.222));
        String string =
                "{\n" +
                "  type:Origin,\n" +
                "  position:{x:1.10, y:2.22},\n" +
                "  bounds:{x:[1.10,1.10], y:[2.22,2.22]},\n" +
                "}";
        assertEquals(instance.toString(), string);
    }

    @Test
    void getChildren() {
        Origin child1 = new Origin(new Coord2D(1, 1));
        Origin child2 = new Origin(new Coord2D(2, 2));
        Point child3 = new Point(new Coord2D(3, 3));
        instance.addChild(child1);
        instance.addChild(child2);
        instance.addChild(child3);

        Set<Vertex> children = instance.getChildren();
        assertEquals(children.size(), 3);
        assertTrue(children.contains(child1));
        assertTrue(children.contains(child2));
        assertTrue(children.contains(child3));
    }

    @Test
    void addChild() {
        Point point = new Point(new Coord2D(-1.0, -9.0));
        instance.addChild(point);
        instance.addChild(new Point(new Coord2D(4.0, 6.0)));
        assertEquals(instance.getBounds().getMinPosition(), new Coord2D(-1.0, -9.0));
        assertEquals(instance.getBounds().getMaxPosition(), new Coord2D(4.0, 6.0));
        assertTrue(instance.getChildren().contains(point));

        instance.addChild(point);
        assertEquals(instance.getChildren().size(), 2);
    }

    @Test
    void addSpaceException() {
        Throwable exception = assertThrows(
                AddSpaceException.class,
                () -> instance.addChild(new Space())
        );
        assertEquals(exception.getMessage(), "Space mustn't be a child\n");
    }

    @Test
    void cycleException() {
        Origin node1 = new Origin();
        Origin node2 = new Origin();
        Origin node3 = new Origin();
        node1.addChild(node2);
        node2.addChild(node3);

        Throwable exception = assertThrows(
                CycleException.class,
                () -> node3.addChild(node1)
        );
        assertEquals(exception.getMessage(), "DAG cannot have a cycle\n");
    }

    @Test
    void removeChild() {
        instance.addChild(instanceFixed);
        assertTrue(instance.getChildren().contains(instanceFixed));

        instance.removeChild(instanceFixed);
        assertFalse(instance.getChildren().contains(instanceFixed));
    }

    @Test
    void removeChildException() {
        Throwable exception = assertThrows(
                RemoveNodeException.class,
                () -> instance.removeChild(instanceFixed)
        );
        assertEquals(exception.getMessage(), "There is no this vertex\n");
    }
}