package com.github.jussiar.api.utils.format;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormatDoubleTest {
    @Test
    void eps() {
        assertEquals(0.00002, 0.00001, FormatDouble.eps);
    }

    @Test
    void format() {
        assertEquals(FormatDouble.format(-1.222), "-1.22");
        assertEquals(FormatDouble.format(-1.227), "-1.23");
        assertEquals(FormatDouble.format(100.1), "100.10");
    }
}