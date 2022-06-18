package edu.hse.jussiar.mappers;

import edu.hse.jussiar.CaseMapper;

import java.util.List;

public class ListMapper implements CaseMapper {
    @Override
    public String map(Object object) {
        StringBuilder result = new StringBuilder();
        result.append("Type: List\n");

        result.append("\tvalue: [");
        List<?> list = (List<?>)object;
        for (var item : list) {
            result.append(item.toString());
            result.append(", ");
        }
        result.append("]\n");
        return result.toString();
    }
}
