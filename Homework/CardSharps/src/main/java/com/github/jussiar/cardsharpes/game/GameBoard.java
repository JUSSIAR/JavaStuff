package com.github.jussiar.cardsharpes.game;

import com.github.jussiar.cardsharpes.interactor.Interactor;
import com.github.jussiar.cardsharpes.participant.player.Player;
import com.github.jussiar.cardsharpes.participant.sharper.Sharper;
import com.github.jussiar.cardsharpes.participant.thread.ThreadParticipant;
import com.github.jussiar.cardsharpes.util.Generator;

import java.util.ArrayList;
import java.util.List;

/**
 * GameBoard entity
 * Here we have multithreading game process
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see Interactor
 * @see Player
 * @see Sharper
 * @see ThreadParticipant
 * @see Generator
 */
public class GameBoard {
    /**
     * Total game duration
     */
    private static final int TOTAL_DURATION = 10 * 1000;
    private final List<Player> players;
    private final List<Sharper> sharpers;

    /**
     * Constructor builds GameBoard from params
     * @param params with playerCount & sharperCount
     */
    public GameBoard(GameParams params) {
        players = new ArrayList<>(params.playerCount());
        sharpers = new ArrayList<>(params.sharperCount());

        for (int i = 0; i < params.playerCount(); i++) {
            players.add(new Player(this));
        }

        for (int i = 0; i < params.sharperCount(); i++) {
            sharpers.add(new Sharper(this));
        }
    }

    /**
     * Game process
     * @apiNote General runner of the game
     */
    public void process() {
        startParticipants();
        gameplay();
        stopParticipants();
    }

    /**
     * Method fixes game timing
     * @see GameBoard
     */
    private void gameplay() {
        try {
            Thread.sleep(GameBoard.TOTAL_DURATION);
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }

    /**
     * Prints a result list of all participants
     * Also prints winner
     * @param interactor Interactor instance
     * @see Interactor
     * @see Player
     * @see Sharper
     */
    public void printResult(Interactor interactor) {
        ThreadParticipant winner = getWinner();
        interactor.printWinner(winner);

        for (Player player : players) {
            interactor.printParticipant(player);
        }
        for (Sharper sharper : sharpers) {
            interactor.printParticipant(sharper);
        }
    }

    /**
     * Method get winner with maximal score
     * @return winner of the game
     * @see ThreadParticipant
     */
    public ThreadParticipant getWinner() {
        System.out.println(players.size());
        ThreadParticipant winner = players.get(0);
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() > winner.getScore()) {
                winner = players.get(i);
            }
        }
        for (int i = 0; i < sharpers.size(); i++) {
            if (sharpers.get(i).getScore() > winner.getScore()) {
                winner = sharpers.get(i);
            }
        }
        return winner;
    }

    /**
     * Starts all participant threads
     * @see ThreadParticipant
     */
    private void startParticipants() {
        for (ThreadParticipant participant : players) {
            participant.start();
        }
        for (ThreadParticipant participant : sharpers) {
            participant.start();
        }
    }

    /**
     * Interrupts all participant threads
     * @see ThreadParticipant
     */
    private void stopParticipants() {
        for (ThreadParticipant participant : players) {
            participant.interrupt();
        }
        for (ThreadParticipant participant : sharpers) {
            participant.interrupt();
        }
    }

    /**
     * Method steals from score from true player
     * @param want value of shaper stealing try
     * @return score for sharper
     * @see Generator
     */
    public int stolenScore(int want) {
        int position = Generator.generatePosition(players.size());
        return players.get(position).stealScore(want);
    }
}
