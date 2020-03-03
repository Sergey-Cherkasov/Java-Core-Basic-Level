package tic.tac.toe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToePlayer {

    private static final char CHIP_X = '\u2718';

    public TicTacToePlayer() {
    }

    public int[] getMove(int sizeArea, char[][] ticTacToeArea, char emptyFieldArea) {
        int[] playerMove = new int[2];
        BufferedReader inputValues = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("\nВаш ход:");
//            move = player.getMove(area.getSizeArea());
            try {
                playerMove[0] = Integer.parseInt(inputValues.readLine());
                playerMove[1] = Integer.parseInt(inputValues.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Вы ввели не числовое значение.\nПоробуйте еще раз.");
            }
        } while (!TicTacToeGameHandler.isCellValid(playerMove, ticTacToeArea, sizeArea, emptyFieldArea));
        return playerMove;
    }

    public char getChipX() {
        return CHIP_X;
    }



}
