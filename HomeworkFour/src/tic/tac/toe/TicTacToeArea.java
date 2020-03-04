package tic.tac.toe;

import java.util.Arrays;

public class TicTacToeArea {
    private char[][] ticTacToeArea;
    private static final int SIZE_AREA = 5;
    private static final int CHIPS_TO_WIN = 4;
    private static final char EMPTY_FIELD_AREA = '\u25FE';

    public TicTacToeArea() {
        this.ticTacToeArea = new char[SIZE_AREA][SIZE_AREA];
    }

    public TicTacToeArea(int sizeArea) {
        this.ticTacToeArea = new char[sizeArea][sizeArea];
    }

    public char[][] getTicTacToeArea() {
        return ticTacToeArea;
    }

    public int getSizeArea() {
        return SIZE_AREA;
    }

    public int getChipsToWin() {
        return CHIPS_TO_WIN;
    }

    public char getEmptyFieldArea() {
        return EMPTY_FIELD_AREA;
    }

    public char getTicTacToeField(int row, int column) {
        return ticTacToeArea[row][column];
    }

    public void initNewArea() {
        for (char[] rows : ticTacToeArea) {
            Arrays.fill(rows, EMPTY_FIELD_AREA);
        }
    }

    public void setMove(int row, int column, char chip) {
        ticTacToeArea[row - 1][column - 1] = chip;
    }

}
