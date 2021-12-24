package com.github.jussiar.cardsharpes.participant.player;

import com.github.jussiar.cardsharpes.game.GameBoard;
import com.github.jussiar.cardsharpes.game.GameParams;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private GameBoard boardInstance;
    private Player playerInstance;

    @BeforeEach
    void setUp() {
        boardInstance = new GameBoard(new GameParams(true, 1, 1));
        playerInstance = new Player(boardInstance);
    }

    @AfterEach
    void tearDown() {
        boardInstance = null;
        playerInstance = null;
    }

    @Test
    void getScore() {
        assertEquals(playerInstance.getScore(), 0);
        playerInstance.addScore(1);
        assertEquals(playerInstance.getScore(), 1);
    }

    @Test
    void takeCard() {
        for (int i = 0; i < 10; i++) {
            Player currentInstance = new Player(boardInstance);
            currentInstance.takeCard();
            assertTrue(currentInstance.getScore() > 0);
        }
    }

    @Test
    void addScore() {
        playerInstance.addScore(2);
        playerInstance.addScore(3);
        assertEquals(playerInstance.getScore(), 2 + 3);
    }

    @Test
    void testToString() {
        Player currentInstance = new Player(boardInstance);
        currentInstance.addScore(5);

        String currId = Integer.toString(Player.getTotalCounter());
        String expected = "Player: id = " + currId + ";\tscore = 5;";
        assertEquals(currentInstance.toString(), expected);
    }

    @Test
    void stealScore() {
        playerInstance.addScore(2);
        int can = playerInstance.stealScore(3);
        assertEquals(can, 2);
        assertEquals(playerInstance.getScore(), 0);

        playerInstance.addScore(5);
        can = playerInstance.stealScore(3);
        assertEquals(can, 3);
        assertEquals(playerInstance.getScore(), 2);
    }

}