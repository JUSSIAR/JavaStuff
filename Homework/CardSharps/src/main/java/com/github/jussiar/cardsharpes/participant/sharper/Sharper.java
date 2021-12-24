package com.github.jussiar.cardsharpes.participant.sharper;

import com.github.jussiar.cardsharpes.game.GameBoard;
import com.github.jussiar.cardsharpes.participant.thread.ThreadParticipant;
import com.github.jussiar.cardsharpes.util.Action;
import com.github.jussiar.cardsharpes.util.Generator;

/**
 * Sharper class
 * It provides us a Sharper, who can not only take a Card
 * but also steal score from true players
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see GameBoard
 * @see Generator
 * @see Action
 * @see ThreadParticipant
 */
public class Sharper extends ThreadParticipant {
    /**
     * Constructor, which builds a Sharper with common board
     * @param board game board
     */
    public Sharper(GameBoard board) {
        super(board);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            int duration;
            synchronized (board) {
                Action action = Generator.generateAction();
                if (action == Action.CARD) {
                    duration = Generator.generatePlayerDuration();
                    takeCard();
                } else {
                    duration = Generator.generateSharperDuration();
                    int cheatScore = Generator.generateCheatScore();
                    addScore(board.stolenScore(cheatScore));
                }
            }

            try {
                Thread.sleep(duration);
            } catch(InterruptedException ie) {
                interrupt();
            }
        }
    }

    @Override
    public final String toString() {
        return "Sharper: " + super.toString();
    }
}
