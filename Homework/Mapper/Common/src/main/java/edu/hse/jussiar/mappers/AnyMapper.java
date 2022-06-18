package edu.hse.jussiar.mappers;

import edu.hse.jussiar.CaseMapper;

import java.lang.reflect.Field;

public class AnyMapper implements CaseMapper {
    @Override
    public String map(Object object) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();
        Class<?> classInside = object.getClass();

        result.append("Type: ");
        result.append(classInside.getName());
        result.append("\n\tvalue: null");
        result.append("\nfields:\n");

        Field[] fieldsArr = classInside.getDeclaredFields();
        for (Field item : fieldsArr) {
            item.trySetAccessible();
            var itemObject = item.get(object);
            result.append("\t\t");
            result.append(item.getName());
            result.append(": ");
            result.append(itemObject.toString());
            result.append('\n');
        }
        return result.toString();
    }
}
