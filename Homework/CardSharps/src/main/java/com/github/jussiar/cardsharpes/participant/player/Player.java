package com.github.jussiar.cardsharpes.participant.player;

import com.github.jussiar.cardsharpes.game.GameBoard;
import com.github.jussiar.cardsharpes.participant.thread.ThreadParticipant;
import com.github.jussiar.cardsharpes.util.Generator;

/**
 * Player class
 * It provides us a Player, who can only take a Card
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see GameBoard
 * @see Generator
 * @see ThreadParticipant
 */
public class Player extends ThreadParticipant {
    /**
     * Constructor, which builds a Sharper with common board
     * @param board game board
     */
    public Player(GameBoard board) {
        super(board);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (board) {
                takeCard();
            }

            try {
                Thread.sleep(Generator.generatePlayerDuration());
            } catch(InterruptedException ie) {
                interrupt();
            }
        }
    }

    /**
     * Method lets us steal score from true Player
     * This checks that we can steal
     * If we can not steal, it will give us all Players score
     * @param want value of score stealing
     * @return removed score value
     */
    public int stealScore(int want) {
        int have = score;
        int can = Math.min(have, want);
        score -= can;
        return can;
    }

    @Override
    public final String toString() {
        return "Player: " + super.toString();
    }
}
