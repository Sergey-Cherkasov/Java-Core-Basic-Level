package tic.tac.toe;

import tic.tac.toe.models.WindowGame;

/**
 * Класс Game - Основной клас игры в крестики-нолики.
 */

public class Game {

    public static void main(String[] args) {

        WindowGame windowGame = new WindowGame();
        windowGame.onInitWindow();
    }

}
