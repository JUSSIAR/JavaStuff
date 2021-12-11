package com.github.jussiar.api.core.bounds;

import com.github.jussiar.api.core.coordinates.Coord2D;
import com.github.jussiar.api.utils.format.FormatDouble;

/**
 * Box witch contains all nodes in sub-DAG
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see Coord2D
 * @see FormatDouble
 */
public class BoundBox {
    private Coord2D minPosition;
    private Coord2D maxPosition;

    public BoundBox() {
        refresh();
    }

    public BoundBox(Coord2D position) {
        this.minPosition = position;
        this.maxPosition = position;
    }

    /**
     * Cleaner for the bounds.
     * @apiNote For making infinity plane.
     */
    public void refresh() {
        this.minPosition = Coord2D.createMax();
        this.maxPosition = Coord2D.createMin();
    }

    /**
     * Trying to update the space bounds.
     * @param position - position of any new entity.
     * @apiNote using with adding a new node.
     */
    public void tryUpdate(Coord2D position) {
        double minX = Double.min(minPosition.x(), position.x());
        double minY = Double.min(minPosition.y(), position.y());
        minPosition = new Coord2D(minX, minY);

        double maxX = Double.max(maxPosition.x(), position.x());
        double maxY = Double.max(maxPosition.y(), position.y());
        maxPosition = new Coord2D(maxX, maxY);
    }

    /**
     * Getter for min coordinates.
     * @return coordinates.
     * @apiNote down and left.
     */
    public Coord2D getMinPosition() {
        return minPosition;
    }

    /**
     * Getter for max coordinates.
     * @return coordinates.
     * @apiNote down and left.
     */
    public Coord2D getMaxPosition() {
        return maxPosition;
    }

    /**
     * String representation.
     * @return string.
     * @apiNote for printing or logging.
     */
    public String toString() {
        if (minPosition.equals(Coord2D.createMax())) {
            return "fullSpace";
        }
        String minPosX = FormatDouble.format(minPosition.x());
        String maxPosX = FormatDouble.format(maxPosition.x());
        String minPosY = FormatDouble.format(minPosition.y());
        String maxPosY = FormatDouble.format(maxPosition.y());
        String xValues = "x:[" + minPosX + "," +  maxPosX + "]";
        String yValues = "y:[" + minPosY + "," +  maxPosY + "]";
        return "{" + xValues + ", " + yValues + "}";
    }
}
