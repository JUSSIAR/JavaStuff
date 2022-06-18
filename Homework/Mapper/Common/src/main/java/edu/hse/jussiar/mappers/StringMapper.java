package edu.hse.jussiar.mappers;

import edu.hse.jussiar.CaseMapper;

public class StringMapper implements CaseMapper {
    @Override
    public String map(Object object) {
        StringBuilder result = new StringBuilder();
        result.append("Type: String\n");
        result.append("\tvalue: ");
        result.append(object.toString());
        result.append('\n');
        return result.toString();
    }
}
