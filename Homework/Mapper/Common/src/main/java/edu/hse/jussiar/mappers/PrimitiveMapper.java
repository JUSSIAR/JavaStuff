package edu.hse.jussiar.mappers;

import edu.hse.jussiar.CaseMapper;

public class PrimitiveMapper implements CaseMapper {
    @Override
    public String map(Object object) {
        StringBuilder result = new StringBuilder();
        result.append("Type: Primitive\n");
        result.append("\tvalue: ");
        result.append(object.toString());
        result.append('\n');
        return result.toString();
    }
}
