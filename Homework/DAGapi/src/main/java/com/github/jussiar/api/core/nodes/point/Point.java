package com.github.jussiar.api.core.nodes.point;

import com.github.jussiar.api.core.bounds.BoundBox;
import com.github.jussiar.api.core.coordinates.Coord2D;
import com.github.jussiar.api.core.nodes.vertex.Vertex;

/**
 * Leaf node of the system
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see Coord2D
 * @see BoundBox
 * @see Vertex
 */
public class Point implements Vertex {
    private Coord2D position;
    private BoundBox bounds;

    public Point() {
        position = Coord2D.createDefault();
        bounds = new BoundBox(position);
    }

    public Point(Coord2D position) {
        this.position = position;
        bounds = new BoundBox(position);
    }

    @Override
    public Coord2D getPosition() {
        return position;
    }

    @Override
    public void setPosition(Coord2D position) {
        this.position = position;
        bounds = new BoundBox(position);
    }

    @Override
    public BoundBox getBounds() {
        return bounds;
    }

    @Override
    public String toString() {
        String typeStr = "  type:Origin" + ",\n";
        String positionStr = "  position:" + position.toString() + ",\n";
        return "{\n" + typeStr + positionStr + "}";
    }
}
