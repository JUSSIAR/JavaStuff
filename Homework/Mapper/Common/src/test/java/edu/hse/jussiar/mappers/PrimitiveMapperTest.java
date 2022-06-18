package edu.hse.jussiar.mappers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveMapperTest {
    public PrimitiveMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new PrimitiveMapper();
    }

    @AfterEach
    void tearDown() {
        mapper = null;
    }

    @Test
    void map() {
        var res = mapper.map(1);
        assertEquals(res, "Type: Primitive\n\tvalue: 1\n");
    }
}