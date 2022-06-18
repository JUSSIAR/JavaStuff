package edu.hse.jussiar;

/**
 * Provide mapping for each type.
 * @apiNote mapping for special case.
 */
public interface CaseMapper {
    /**
     * Mapping method.
     * @param object to map.
     * @return serialized.
     */
    String map(Object object) throws IllegalAccessException;
}
