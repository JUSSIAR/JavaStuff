package edu.hse.jussiar.mappers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListMapperTest {
    public ListMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ListMapper();
    }

    @AfterEach
    void tearDown() {
        mapper = null;
    }

    @Test
    void map() {
        var list = new LinkedList<Integer>();
        var res = mapper.map(list);
        assertEquals(res, "Type: List\n\tvalue: []\n");
    }
}