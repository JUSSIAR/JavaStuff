package com.github.jussiar.cardsharpes;

import com.github.jussiar.cardsharpes.game.GameBoard;
import com.github.jussiar.cardsharpes.game.GameParams;
import com.github.jussiar.cardsharpes.interactor.Interactor;

/**
 * Main class
 * @author Klokov Stas 201
 * @version 1.0.0
 */
public class CardShapesMain {
    public static void main(String[] args) {
        Interactor interactor = new Interactor();

        interactor.start();
        GameParams params = interactor.getData();

        if (params.isValid()) {
            GameBoard board = new GameBoard(params);
            board.process();
            board.printResult(interactor);
        }
        interactor.finish();
    }
}
