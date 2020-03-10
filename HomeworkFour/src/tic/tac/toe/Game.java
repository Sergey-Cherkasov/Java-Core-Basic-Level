package tic.tac.toe;

import tic.tac.toe.Handlers.GameHandler;
import tic.tac.toe.Models.Area;
import tic.tac.toe.Models.Computer;
import tic.tac.toe.Models.Player;

/**
 * Класс Game - Основной клас игры в крестики-нолики.
 */

public class Game {

    // Объявляем экземпляр класса "Поле"
    static Area area;
    // Объявляем экземпляр класса "Игрок"
    static Player player;
    // Объявляем экземпляр класса "Компьютер"
    static Computer computer;
    static final char EMPTY_CHAR = ' ';

    public static void main(String[] args) {
        System.out.println("Предлагаю сыграть в консольную игру \"Крестики-нолики\" на игровом поле 5х5.");
        GameHandler.pressEnterKeyToContinue();

        area = new Area();
        player = new Player();
        // Передаем экземпляру "Компютер" размер поля
        computer = new Computer(area.getSizeArea());
        // Заполняем поле пустыми значениями '◾'
        area.setNewArea();
        // Отображаем в консоли игровое поле
        printAreaHeader();
        printArea();
        /*
        * В бесконечном цикле поочереди осуществляют свои ходы игрок и компьютер.
        * После каждого хода проверяется результат на выигрыш/прогрыш/ничью
         */
        do {
            playerMove();
            if (GameHandler.checkWin(area.getTicTacToeArea(),
                    area.getChipsToWin(),
                    player.getChipX())) {
                System.out.println("Вы победили!");
                return;
            }
            if (GameHandler.isAreaFull(area.getTicTacToeArea(),
                    area.getSizeArea(),
                    area.getEmptyFieldArea())) {
                System.out.println("Ничья");
                return;
            }
            computerMove();
            if (GameHandler.checkWin(area.getTicTacToeArea(),
                    area.getChipsToWin(),
                    computer.getChipO())) {
                System.out.println("Победил компьютер");
                return;
            }
            if (GameHandler.isAreaFull(area.getTicTacToeArea(),
                    area.getSizeArea(),
                    area.getEmptyFieldArea())) {
                System.out.println("Ничья");
                return;
            }
        } while (true);
    }

    //
    public static void playerMove() {
        int[] move;
        move = player.getMove(
                              area.getSizeArea(),
                              area.getTicTacToeArea(),
                              area.getEmptyFieldArea());
        area.setMove(move[GameHandler.FIRST_ELEMENT], move[GameHandler.SECOND_ELEMENT], player.getChipX());
        printAreaHeader();
        printArea();
    }

    public static void computerMove() {
        int[] move;
        move = computer.getMove(
                                 area.getSizeArea(),
                                 area.getTicTacToeArea(),
                                 area.getEmptyFieldArea(),
                                 area.getChipsToWin(),
                                 player.getChipX());
        area.setMove(move[GameHandler.FIRST_ELEMENT], move[GameHandler.SECOND_ELEMENT], computer.getChipO());
        printAreaHeader();
        printArea();
    }

    public static void printAreaHeader() {
        System.out.println("\nПоле:");
        System.out.printf("%2c", EMPTY_CHAR);
        for (int column = 0; column < area.getSizeArea(); column++) {
            System.out.print((column + 1) + "  ");
        }
        System.out.println();
    }

    public static void printArea() {
        for (int row = 0; row < area.getSizeArea(); row++) {
            System.out.print("" + (row + 1) + EMPTY_CHAR);
            for (int column = 0; column < area.getSizeArea(); column++) {
                System.out.print(area.getTicTacToeField(row, column) + " ");
            }
            System.out.println();
        }
    }

}
