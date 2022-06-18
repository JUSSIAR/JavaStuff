package edu.hse.jussiar.mappers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMapperTest {
    public StringMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StringMapper();
    }

    @AfterEach
    void tearDown() {
        mapper = null;
    }

    @Test
    void map() {
        var res = mapper.map("abc");
        assertEquals(res, "Type: String\n\tvalue: abc\n");
    }
}