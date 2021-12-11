package com.github.jussiar.api.core.nodes.vertex;

import com.github.jussiar.api.core.bounds.BoundBox;
import com.github.jussiar.api.core.coordinates.Coord2D;

/**
 * Node interface
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see Coord2D
 * @see BoundBox
 */
public interface Vertex {
    /**
     * Getter for position.
     * @return coordinates.
     * @apiNote using for any goals with coordinate.
     */
    Coord2D getPosition();

    /**
     * Setter for position.
     * @param newPosition - new pos for node entity.
     * @apiNote using for any goals with coordinate.
     */
    void setPosition(Coord2D newPosition);

    /**
     * Getter for bounds.
     * @return coordinate bounds.
     * @apiNote using for any goals with bounds.
     */
    BoundBox getBounds();

    /**
     * String representation.
     * @return string.
     * @apiNote printing or logging.
     */
    String toString();
}
