package com.github.jussiar.api.core.nodes.origin;

import com.github.jussiar.api.core.bounds.BoundBox;
import com.github.jussiar.api.core.coordinates.Coord2D;
import com.github.jussiar.api.core.nodes.point.Point;
import com.github.jussiar.api.core.nodes.space.Space;
import com.github.jussiar.api.core.nodes.vertex.Vertex;
import com.github.jussiar.api.exceptions.AddSpaceException;
import com.github.jussiar.api.exceptions.CycleException;
import com.github.jussiar.api.exceptions.DAGException;
import com.github.jussiar.api.exceptions.RemoveNodeException;
import com.github.jussiar.api.utils.checker.Cycled;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The system of coordinated nodes
 * with bounds and started difference
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see Coord2D
 * @see Vertex
 * @see BoundBox
 * @see DAGException
 * @see AddSpaceException
 * @see CycleException
 * @see RemoveNodeException
 * @see Cycled
 * @see Space
 * @see Point
 */
public class Origin implements Vertex {
    private Coord2D position;
    private BoundBox bounds;
    private Set<Vertex> children;

    public Origin() {
        position = Coord2D.createDefault();
        bounds = new BoundBox(position);
        children = new HashSet<>();
    }

    public Origin(Coord2D position) {
        this.position = position;
        bounds = new BoundBox(position);
        children = new HashSet<>();
    }

    @Override
    public Coord2D getPosition() {
        return position;
    }

    @Override
    public void setPosition(Coord2D position) {
        this.position = position;
    }

    @Override
    public BoundBox getBounds() {
        calculateBounds();
        return bounds;
    }

    @Override
    public String toString() {
        calculateBounds();
        String typeStr = "  type:Origin" + ",\n";
        String positionStr = "  position:" + position.toString() + ",\n";
        String boundsStr = "  bounds:" + bounds.toString() + ",\n";
        return "{\n" + typeStr + positionStr + boundsStr + "}";
    }

    /**
     * Getter for children set.
     * @return children.
     * @apiNote using for getting all sub-DAGs.
     */
    public Set<Vertex> getChildren() {
        return Collections.unmodifiableSet(children);
    }

    /**
     * Adding new child.
     * @param newNode - an interface for all node entities.
     * @apiNote using for push a new child.
     */
    public void addChild(Vertex newNode) throws DAGException {
        if (newNode instanceof Space) {
            throw new AddSpaceException("Space mustn't be a child");
        }
        children.add(newNode);
        if (Cycled.isCycled(this)) {
            children.remove(newNode);
            throw new CycleException("DAG cannot have a cycle");
        }
    }

    /**
     * Removing node.
     * @param nodeToRemove an interface for all node entities.
     * @apiNote using for remove a child.
     */
    public void removeChild(Vertex nodeToRemove) throws RemoveNodeException {
        if (!children.contains(nodeToRemove)) {
            throw new RemoveNodeException("There is no this vertex");
        }
        children.remove(nodeToRemove);
    }

    /**
     * Bounds recalculation
     */
    private void calculateBounds() {
        bounds.refresh();
        bounds.tryUpdate(position);
        HashSet<Vertex> used = new HashSet<>();
        for (Vertex vertex : getChildren()) {
            deepCalculate(vertex, used, vertex.getPosition());
        }
    }

    /**
     * Bounds recursive recalculation
     * @param vertex, used, curr
     */
    private void deepCalculate(Vertex vertex, HashSet<Vertex> used, Coord2D curr) {
        if (used.contains(vertex)) {
            return;
        }
        used.add(vertex);
        bounds.tryUpdate(curr);
        if (vertex instanceof Point) {
            return;
        }

        for (Vertex child : ((Origin)vertex).getChildren()) {
            double x = curr.x() + child.getPosition().x();
            double y = curr.y() + child.getPosition().y();
            deepCalculate(child, used, new Coord2D(x, y));
        }
    }
}
