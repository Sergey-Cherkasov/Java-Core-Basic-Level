package tic.tac.toe;

import java.util.Random;

public class TicTacToeComputer {
    private static final char CHIP_O = '\u24B8';
    private int sizeArea;

    public TicTacToeComputer(int sizeArea) {
        this.sizeArea = sizeArea;
    }

    public char getChipO() {
        return CHIP_O;
    }

    public int[] getMove(int sizeArea, char[][] ticTacToeArea, char emptyFieldArea, int chipsToWin, char playerChipX) {
        Random random = new Random();
        int[] computerMove;
        System.out.print("\nХод компьютера:");
        do {
            if ((computerMove = checkRowsToBlock(ticTacToeArea, chipsToWin, playerChipX)).length != 0 &&
                    TicTacToeGameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea, emptyFieldArea)) {
                break;
            }
            if ((computerMove = checkColumnsToBlock(ticTacToeArea, chipsToWin, playerChipX)).length != 0 &&
                    TicTacToeGameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea, emptyFieldArea)) {
                break;
            }
            if ((computerMove = checkLeftDiagonalToBlock(ticTacToeArea, chipsToWin, playerChipX)).length != 0 &&
                    TicTacToeGameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea, emptyFieldArea)) {
                break;
            }
            if ((computerMove = checkRightDiagonalToBlock(ticTacToeArea, chipsToWin, playerChipX)).length != 0 &&
                    TicTacToeGameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea, emptyFieldArea)) {
                break;
            }
            computerMove = new int[2];
            computerMove[0] = random.nextInt(this.sizeArea) + 1;
            computerMove[1] = random.nextInt(this.sizeArea) + 1;
        } while (!TicTacToeGameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea, emptyFieldArea));
        System.out.println(computerMove[0] + " " + computerMove[1]);
        return computerMove;
    }

    private int[] checkRightDiagonalToBlock(char[][] ticTacToeArea, int chipsToWin, char playerChipX) {
        int numberLastElement = ticTacToeArea.length - 1;
        int count = 0;
        for (int row = 0; row < ticTacToeArea.length; row++) {
            if (ticTacToeArea[row][numberLastElement - row] == playerChipX) {
                count++;
                if (count == (chipsToWin - 1))
                    if (row == numberLastElement) return new int[]{ticTacToeArea.length - count, chipsToWin};
                    else return new int[]{row + 2, ticTacToeArea.length - (chipsToWin - 1)};
            } else count = 0;
        }
        return new int[0];
    }

    private int[] checkLeftDiagonalToBlock(char[][] ticTacToeArea, int chipsToWin, char playerChipX) {
        int numberLastElement = ticTacToeArea.length - 1;
        int count = 0;
        for (int row = 0; row < ticTacToeArea.length; row++) {
            if (ticTacToeArea[row][row] == playerChipX) {
                count++;
                if (count == (chipsToWin - 1))
                    if (row == numberLastElement) return new int[]{ticTacToeArea.length - count,
                            ticTacToeArea.length - count};
                    else return new int[]{row + 2, row + 2};
            } else count = 0;
        }
        return new int[0];
    }

    private int[] checkColumnsToBlock(char[][] ticTacToeArea, int chipsToWin, char playerChipX) {
        int numberLastElement = ticTacToeArea.length - 1;
        for (int column = 0; column < ticTacToeArea.length; column++) {
            int count = 0;
            for (int row = 0; row < ticTacToeArea.length; row++) {
                if (ticTacToeArea[row][column] == playerChipX) {
                    count++;
                    if (count == (chipsToWin - 1)) {
                        if (row == numberLastElement) return new int[]{ticTacToeArea.length - count, column + 1};
                        else return new int[]{row + 2, column + 1};
                    }
                } else count = 0;
            }
        }
        return new int[0];
    }

    private int[] checkRowsToBlock(char[][] ticTacToeArea, int chipsToWin, char playerChipX) {
        int numberLastElement = ticTacToeArea.length - 1;
        for (int row = 0; row < ticTacToeArea.length; row++) {
            int count = 0;
            for (int column = 0; column < ticTacToeArea.length; column++) {
                if (ticTacToeArea[row][column] == playerChipX) {
                    count++;
                    if (count == (chipsToWin - 1)) {
                        if (column == numberLastElement) return new int[]{row + 1, ticTacToeArea.length - count};
                        else return new int[]{row + 1, column + 2};
                    }
                } else count = 0;
            }
        }
        return new int[0];
    }

}
