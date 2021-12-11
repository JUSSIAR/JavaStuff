package com.github.jussiar.api.exceptions;

/**
 * @apiNote With adding an edge and making a cycle.
 * @author Klokov Stas
 * @version 1.0.0
 * @see DAGException
 */
public class CycleException extends DAGException {
    public CycleException(String message) {
        super(message);
    }
}
