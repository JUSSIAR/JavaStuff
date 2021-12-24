package com.github.jussiar.cardsharpes.interactor;

import com.github.jussiar.cardsharpes.game.GameParams;
import com.github.jussiar.cardsharpes.participant.Participant;

import java.util.Scanner;

/**
 * Game Intarator
 * This entity provides an interaction with user
 * This is api for interacting
 * Also we have validating & parsing here
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see GameParams
 * @see Participant
 */
public class Interactor {
    /**
     * Scanner instance for console input
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Provides data for game board
     * @return game params in true format
     * @see GameParams
     */
    public GameParams getData() {
        System.out.println("Enter players count (int type):");
        String rawPlayersCount = scanner.nextLine();

        System.out.println("Enter sharpers count (int type):");
        String rawSharpersCount = scanner.nextLine();

        return parser(rawPlayersCount, rawSharpersCount);
    }

    /**
     * Parser for input data
     * @param rawPlayersCount row view of player count
     * @param rawSharpersCount row view of sharper count
     * @return game params
     * @see GameParams
     */
    public GameParams parser(String rawPlayersCount, String rawSharpersCount) {
        int playersCount;
        int sharpersCount;
        try {
            String players = rawPlayersCount.trim();
            String sharpers = rawSharpersCount.trim();
            playersCount = Integer.parseInt(players);
            sharpersCount = Integer.parseInt(sharpers);
        } catch (Exception ignored) {
            System.out.println("invalid input data format");
            return new GameParams(false, 0, 0);
        }
        if (playersCount < 1) {
            return new GameParams(false, 0, 0);
        }
        if (sharpersCount < 0) {
            return new GameParams(false, 0, 0);
        }
        return new GameParams(true, playersCount, sharpersCount);
    }

    /**
     * Game start message
     */
    public void start() {
        System.out.println("Program started");
    }

    /**
     * Game finish message
     */
    public void finish() {
        System.out.println("Program finished");
    }

    /**
     * Prints winner of the game
     * @param participant Winner
     * @see Participant
     */
    public void printWinner(Participant participant) {
        System.out.print("\nWinner: ");
        System.out.println(participant.toString() + "\n");
    }

    /**
     * Prints participant
     * @param participant any participant
     * @see Participant
     */
    public void printParticipant(Participant participant) {
        System.out.print("Participant: ");
        System.out.println(participant.toString());
    }
}
