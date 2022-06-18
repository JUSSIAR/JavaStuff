package edu.hse.jussiar.mappers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnyMapperTest {
    public AnyMapper mapper;

    public static class A {
        public int a;
        public int b;

        A() {
            a = 1;
            b = 2;
        }
    };

    @BeforeEach
    void setUp() {
        mapper = new AnyMapper();
    }

    @AfterEach
    void tearDown() {
        mapper = null;
    }

    @Test
    void map() throws IllegalAccessException {
        var res = mapper.map(new AnyMapperTest.A());
        assertEquals(res, "");
    }
}