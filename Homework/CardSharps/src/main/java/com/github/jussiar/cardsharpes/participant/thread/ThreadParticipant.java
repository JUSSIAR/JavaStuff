package com.github.jussiar.cardsharpes.participant.thread;

import com.github.jussiar.cardsharpes.game.GameBoard;
import com.github.jussiar.cardsharpes.participant.Participant;
import com.github.jussiar.cardsharpes.util.Generator;

/**
 * ThreadParticipant abstract class
 * This entity provides common type of our participants
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see Participant
 * @see Generator
 * @see GameBoard
 */
public abstract class ThreadParticipant extends Thread implements Participant {
    /**
     * Total counter of Participants
     * This provides us an opportunity
     * to get id for every ThreadParticipant
     */
    private static int counter = 0;

    protected int score;
    protected int id;
    protected final GameBoard board;

    public ThreadParticipant(GameBoard board) {
        this.board = board;
        score = 0;
        id = ++ThreadParticipant.counter;
    }

    /**
     * provides count of Participants in general
     * @return counter
     */
    public static int getTotalCounter() {
        return ThreadParticipant.counter;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void takeCard() {
        addScore(Generator.generateCard());
    }

    @Override
    public void addScore(int delta) {
        score += delta;
    }

    @Override
    public String toString() {
        String strId = "id = " + Integer.toString(id) + ";";
        String strScore = "score = " + Integer.toString(score) + ";";
        return strId + "\t" + strScore;
    }
}
