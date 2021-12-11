package com.github.jussiar.api.core.nodes.space;

import com.github.jussiar.api.core.nodes.origin.Origin;

/**
 * Coordinates on plane
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see Origin
 */
public class Space extends Origin {
    public static final String info = "The root of the World";

    public Space() {
        super();
    }

    @Override
    public String toString() {
        String typeStr = "  type:Space" + ",\n";
        String positionStr = "  position:" + getPosition().toString() + ",\n";
        String boundsStr = "  bounds:" + getBounds().toString() + ",\n";
        return "{\n" + typeStr + positionStr + boundsStr + "}";
    }
}
