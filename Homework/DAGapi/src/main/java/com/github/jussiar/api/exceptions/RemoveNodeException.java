package com.github.jussiar.api.exceptions;

/**
 * @apiNote With removing non-exist child.
 * @author Klokov Stas
 * @version 1.0.0
 * @see DAGException
 */
public class RemoveNodeException extends DAGException {
    public RemoveNodeException(String message) {
        super(message);
    }
}
