package com.github.jussiar.cardsharpes.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Generator of all random entities
 * @author Klokov Stas 201
 * @version 1.0.0
 * @see ThreadLocalRandom
 */
public class Generator {
    private static final int MIN_CARD_BOUND = 1;
    private static final int MAX_CARD_BOUND = 11;

    private static final int MIN_SLEEP_PLAYER = 100;
    private static final int MAX_SLEEP_PLAYER = 201;

    private static final int MIN_SLEEP_SHARPER = 180;
    private static final int MAX_SLEEP_SHARPER = 301;

    private static final int MIN_PERCENT = 1;
    private static final int MAX_PERCENT = 101;

    private static final int MIN_CHEAT_SCORE = 0;
    private static final int MAX_CHEAT_SCORE = 9;

    private static int totalScoreGenerated = 0;

    public static void initTotalScore() {
        Generator.totalScoreGenerated = 0;
    }

    public static int getTotalScore() {
        return Generator.totalScoreGenerated;
    }

    public static int generateCard() {
        int cardScore = Generator.getRandom(MIN_CARD_BOUND, MAX_CARD_BOUND);
        Generator.totalScoreGenerated += cardScore;
        return cardScore;
    }

    public static int generateCheatScore() {
        return Generator.getRandom(MIN_CHEAT_SCORE, MAX_CHEAT_SCORE);
    }

    public static int generatePlayerDuration() {
        return Generator.getRandom(MIN_SLEEP_PLAYER, MAX_SLEEP_PLAYER);
    }

    public static int generateSharperDuration() {
        return Generator.getRandom(MIN_SLEEP_SHARPER, MAX_SLEEP_SHARPER);
    }

    public static Action generateAction() {
        int percent = Generator.getRandom(MIN_PERCENT, MAX_PERCENT);
        return (percent <= 40) ? Action.CHEAT : Action.CARD;
    }

    public static int generatePosition(int size) {
        return getRandom(0, size);
    }

    private static int getRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
