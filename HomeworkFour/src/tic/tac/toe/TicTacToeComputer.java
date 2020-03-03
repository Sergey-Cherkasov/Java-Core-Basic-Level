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
        int[] computerMove = null;
        System.out.print("\nХод компьютера:");
        do {
            if ((computerMove = checkRowsToBlock(ticTacToeArea, chipsToWin, playerChipX)) == null){
                if((computerMove = checkColumnsToBlock(ticTacToeArea, chipsToWin, playerChipX)) == null){
                    if ((computerMove = checkLeftDiagonalToBlock(ticTacToeArea, chipsToWin, playerChipX)) == null) {
                        if ((computerMove = checkRightDiagonalToBlock(ticTacToeArea, chipsToWin, playerChipX)) == null){
                            computerMove = new int[2];
                            computerMove[0] = random.nextInt(this.sizeArea) + 1;
                            computerMove[1] = random.nextInt(this.sizeArea) + 1;
                        }
                    }
                }
            }
        } while (!TicTacToeGameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea, emptyFieldArea));
        System.out.println(computerMove[0] + " " + computerMove[1]);
        return computerMove;
    }

    private int[] checkRightDiagonalToBlock(char[][] ticTacToeArea, int chipsToWin, char playerChipX) {
        int countToBlock = 0;
        int countElements = ticTacToeArea.length - 1;
        for (int row = 0; row < ticTacToeArea.length; row++) {
            if (ticTacToeArea[row][countElements - row] == playerChipX) {
                countToBlock++;
                if (countToBlock == (chipsToWin - 1)) return new int[] {row + 2, row - 2};
            } else countToBlock = 0;
        }
        return null;
    }

    private int[] checkLeftDiagonalToBlock(char[][] ticTacToeArea, int chipsToWin, char playerChipX) {
        int countToBlock = 0;
        for (int row = 0; row < ticTacToeArea.length; row++) {
            if (ticTacToeArea[row][row] == playerChipX) {
                countToBlock++;
                if (countToBlock == (chipsToWin - 1)) return new int[] {row + 2, row + 2};
            } else countToBlock = 0;
        }
        return null;
    }

    private int[] checkColumnsToBlock(char[][] ticTacToeArea, int chipsToWin, char playerChipX) {
        for (int column = 0; column < ticTacToeArea.length; column++) {
            int countToBlock = 0;
            for (int row = 0; row < ticTacToeArea.length; row++) {
                if (ticTacToeArea[row][column] == playerChipX) {
                    countToBlock++;
                    if (countToBlock == (chipsToWin - 1)) return new int[] {row + 2, column + 1};
                } else countToBlock = 0;
            }
        }
        return null;
    }

    private int[] checkRowsToBlock(char[][] ticTacToeArea, int chipsToWin, char playerChipX) {
        int numberLastElement = ticTacToeArea.length - 1;
        for (int row = 0; row < ticTacToeArea.length; row++) {
            int countToBlockLeft = 0;
            int countToBlockRight = 0;
            for (int column = 0; column < ticTacToeArea.length; column++) {
                if (ticTacToeArea[row][column] == playerChipX) {
                    countToBlockLeft++;
                    if (countToBlockLeft == (chipsToWin - 1)) return new int[] {row + 1, column + 2};
                }
                if (ticTacToeArea[row][numberLastElement - column] == playerChipX) {
                    countToBlockRight++;
                    if (countToBlockRight == (chipsToWin - 1)) return new int[] {row + 1, numberLastElement -(column + 2)};
                } else countToBlockRight = 0;
            }
        }
        return null;
    }

}
