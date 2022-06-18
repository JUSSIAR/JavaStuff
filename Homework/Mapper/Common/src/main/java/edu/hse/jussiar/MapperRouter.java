package edu.hse.jussiar;

import edu.hse.jussiar.mappers.AnyMapper;
import edu.hse.jussiar.mappers.ListMapper;
import edu.hse.jussiar.mappers.PrimitiveMapper;
import edu.hse.jussiar.mappers.StringMapper;

import java.util.List;

/**
 * Routes Mapper cases
 * @apiNote router.
 * @see edu.hse.jussiar.mappers.ListMapper
 * @see edu.hse.jussiar.mappers.PrimitiveMapper
 * @see edu.hse.jussiar.mappers.StringMapper
 * @see edu.hse.jussiar.mappers.AnyMapper
 */
public class MapperRouter {
    private static CaseMapper mapper;
    public static String map(Object object) throws IllegalAccessException {
        if (object == null) {
            return "";
        }

        if (object.getClass().isPrimitive()) {
            mapper = new PrimitiveMapper();
            return mapper.map(object);
        }

        if (object.getClass().equals(String.class)) {
            mapper = new StringMapper();
            return mapper.map(object);
        }

        if (List.class.isAssignableFrom(object.getClass())) {
            mapper = new ListMapper();
            return mapper.map(object);
        }

        mapper = new AnyMapper();
        return mapper.map(object);
    }
}
