package com.github.jussiar.cardsharpes.participant;

/**
 * Participant interface
 * This entity fixes
 * @author Klokov Stas 201
 * @version 1.0.0
 */
public interface Participant {
    /**
     * Getter for score
     * @return score value of the participant
     */
    int getScore();

    /**
     * Process of getting card from deck
     */
    void takeCard();

    /**
     * Method rises participant's score
     * @param delta value of score rising
     */
    void addScore(int delta);

    /**
     * Provides string representation for interaction
     * @return string representation
     */
    String toString();
}
