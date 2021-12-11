package com.github.jussiar.api.exceptions;

/**
 * @apiNote With adding a space as a child.
 * @author Klokov Stas
 * @version 1.0.0
 * @see RuntimeException
 */
public class DAGException extends RuntimeException {
    public DAGException(String message) {
        super(message + "\n");
    }
}
