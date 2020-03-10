package tic.tac.toe.Models;

import tic.tac.toe.Handlers.PlayerHandler;

public class Player {

    private static final char CHIP_X = '\u2718';
    PlayerHandler playerHandler = new PlayerHandler();

    public Player() {
    }

    public int[] getMove(int sizeArea, char[][] ticTacToeArea, char emptyFieldArea) {
        return playerHandler.movePlayer(sizeArea, ticTacToeArea, emptyFieldArea);
    }

    public char getChipX() {
        return CHIP_X;
    }


}
