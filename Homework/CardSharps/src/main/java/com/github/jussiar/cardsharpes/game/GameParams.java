package com.github.jussiar.cardsharpes.game;

/**
 * GameParams
 * This includes two general values:
 * - playerCount - count of players
 * - sharperCount - count of sharpers
 * And helper field:
 * - isValid - marker of input data
 * @author Klokov Stas 201
 * @version 1.0.0
 */
public record GameParams(
        boolean isValid,
        int playerCount,
        int sharperCount
) {
}
