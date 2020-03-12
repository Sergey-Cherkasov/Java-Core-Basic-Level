package tic.tac.toe.Handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс PlayerHandler обеспечивает логику хода игрока.
 */
public class PlayerHandler {

    public int[] movePlayer(int sizeArea, char[][] ticTacToeArea, char emptyFieldArea) {
        int[] playerMove = new int[2];
        BufferedReader inputValues = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("\nВаш ход:");
            try {
                playerMove[0] = Integer.parseInt(inputValues.readLine());
                playerMove[1] = Integer.parseInt(inputValues.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Вы ввели не числовое значение.\nПоробуйте еще раз.");
            }
        } while (!GameHandler.isCellValid(playerMove, ticTacToeArea, sizeArea, emptyFieldArea));
        return playerMove;
    }

}
