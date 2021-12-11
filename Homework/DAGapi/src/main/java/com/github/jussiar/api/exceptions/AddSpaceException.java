package com.github.jussiar.api.exceptions;

/**
 * @apiNote With adding a space as a child.
 * @author Klokov Stas
 * @version 1.0.0
 * @see DAGException
 */
public class AddSpaceException extends DAGException {
    public AddSpaceException(String message) {
        super(message);
    }
}
