package com.github.jussiar.cardsharpes.participant.sharper;

import com.github.jussiar.cardsharpes.game.GameBoard;
import com.github.jussiar.cardsharpes.game.GameParams;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharperTest {
    private GameBoard boardInstance;
    private Sharper sharperInstance;

    @BeforeEach
    void setUp() {
        boardInstance = new GameBoard(new GameParams(true, 1, 1));
        sharperInstance = new Sharper(boardInstance);
    }

    @AfterEach
    void tearDown() {
        boardInstance = null;
        sharperInstance = null;
    }

    @Test
    void getScore() {
        assertEquals(sharperInstance.getScore(), 0);
        sharperInstance.addScore(1);
        assertEquals(sharperInstance.getScore(), 1);
    }

    @Test
    void takeCard() {
        for (int i = 0; i < 10; i++) {
            Sharper currentInstance = new Sharper(boardInstance);
            currentInstance.takeCard();
            assertTrue(currentInstance.getScore() > 0);
        }
    }

    @Test
    void addScore() {
        sharperInstance.addScore(2);
        sharperInstance.addScore(3);
        assertEquals(sharperInstance.getScore(), 2 + 3);
    }

    @Test
    void testToString() {
        Sharper currentInstance = new Sharper(boardInstance);
        currentInstance.addScore(5);

        String currId = Integer.toString(Sharper.getTotalCounter());
        String expected = "Sharper: id = " + currId + ";\tscore = 5;";
        assertEquals(currentInstance.toString(), expected);
    }
}