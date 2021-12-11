package com.github.jussiar.api.utils.checker;

import com.github.jussiar.api.core.nodes.origin.Origin;
import com.github.jussiar.api.core.nodes.point.Point;
import com.github.jussiar.api.core.nodes.vertex.Vertex;

import java.util.HashMap;

/**
 * Node interface
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see Vertex
 * @see Point
 * @see Origin
 */
public class Cycled {

    /**
     * Checking for cycled.
     * @param vertex root of sub-DAG.
     * @return true or false on need.
     */
    public static boolean isCycled(Vertex vertex) {
        HashMap<Vertex, Color> color = new HashMap<>();
        return !dfsChecker(vertex, color);
    }

    /**
     * Checking for cycled recursive.
     * @param vertex, color
     * @return true or false on need
     */
    private static boolean dfsChecker(Vertex vertex, HashMap<Vertex, Color> color) {
        if (vertex instanceof Point) {
            color.put(vertex, Color.BLACK);
            return true;
        }
        if (color.containsKey(vertex)) {
            return color.get(vertex).equals(Color.BLACK);
        }

        color.put(vertex, Color.GREY);
        for (Vertex child : ((Origin)vertex).getChildren()) {
            if (!dfsChecker(child, color)) {
                return false;
            }
        }
        color.put(vertex, Color.BLACK);
        return true;
    }
}
