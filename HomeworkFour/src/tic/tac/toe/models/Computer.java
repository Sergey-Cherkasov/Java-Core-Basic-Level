package tic.tac.toe.models;

import tic.tac.toe.handlers.ComputerHandler;

public class Computer {
    private static final char CHIP_O = '\u24B8';
    private int sizeArea;

    ComputerHandler computerHandler = new ComputerHandler();

    public Computer(int sizeArea) {
        this.sizeArea = sizeArea;
    }

    public char getChipO() {
        return CHIP_O;
    }

    public int[] getMove(int sizeArea, char[][] ticTacToeArea, char emptyFieldArea, int chipsToWin, char playerChipX) {
        return computerHandler.moveComputer(sizeArea, ticTacToeArea, emptyFieldArea, chipsToWin, playerChipX, CHIP_O);
    }
}
