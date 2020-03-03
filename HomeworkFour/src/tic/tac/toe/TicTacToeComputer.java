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

    public int[] getMove(int sizeArea, char[][] ticTacToeArea, char emptyFieldArea) {
        Random random = new Random();
        int[] computerMove = new int[2];
        do {
            System.out.print("\nХод компьютера:");
            computerMove[0] = random.nextInt(this.sizeArea) + 1;
            computerMove[1] = random.nextInt(this.sizeArea) + 1;
        } while (!TicTacToeGameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea, emptyFieldArea));

        System.out.println(computerMove[0] + " " + computerMove[1]);
        return computerMove;
    }

}
