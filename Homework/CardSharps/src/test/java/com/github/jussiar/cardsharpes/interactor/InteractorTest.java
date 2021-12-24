package com.github.jussiar.cardsharpes.interactor;

import com.github.jussiar.cardsharpes.game.GameParams;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InteractorTest {

    @Test
    void parser() {
        Interactor instance = new Interactor();

        String row1 = "0";
        String row2 = "0";
        GameParams answer1 = instance.parser(row1, row2);
        assertFalse(answer1.isValid());

        String row3 = "1";
        String row4 = "1.1";
        GameParams answer2 = instance.parser(row3, row4);
        assertFalse(answer2.isValid());

        String row5 = "1";
        String row6 = "1.1";
        GameParams answer3 = instance.parser(row5, row6);
        assertFalse(answer3.isValid());

        String row7 = "4";
        String row8 = "5";
        GameParams answer4 = instance.parser(row7, row8);
        assertTrue(answer4.isValid());
        assertEquals(answer4.playerCount(), 4);
        assertEquals(answer4.sharperCount(), 5);
    }
}