package tic.tac.toe.handlers;

import java.util.Random;

/**
 * Класс ComputerHandler обеспечивает логику хода компьютера в зависимости от расположенных на игровом поле ячеек,
 * занятых игроком.
 */
public class ComputerHandler {
    // Ход компьютера
    public int[] moveComputer(int sizeArea, char[][] ticTacToeArea, char emptyFieldArea,
                              int chipsToWin, char playerChipX, char computerChipO) {
        Random random = new Random();
        int[] computerMove;
        System.out.print("\nХод компьютера:");
        do {
            if ((computerMove = checkRowsToBlock(ticTacToeArea, chipsToWin, emptyFieldArea, playerChipX,
                    computerChipO)).length != 0 && GameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea,
                    emptyFieldArea)) {
                break;
            }
            if ((computerMove = checkColumnsToBlock(ticTacToeArea, chipsToWin, emptyFieldArea, playerChipX,
                    computerChipO)).length != 0 && GameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea,
                    emptyFieldArea)) {
                break;
            }
            if ((computerMove = checkLeftDiagonalToBlock(ticTacToeArea, chipsToWin, playerChipX)).length != 0 &&
                    GameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea, emptyFieldArea)) {
                break;
            }
            if ((computerMove = checkRightDiagonalToBlock(ticTacToeArea, chipsToWin, playerChipX)).length != 0 &&
                    GameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea, emptyFieldArea)) {
                break;
            }
            computerMove = new int[2];
            computerMove[0] = random.nextInt(sizeArea) + 1;
            computerMove[1] = random.nextInt(sizeArea) + 1;
        } while (!GameHandler.isCellValid(computerMove, ticTacToeArea, sizeArea, emptyFieldArea));
        System.out.println(computerMove[0] + " " + computerMove[1]);
        return computerMove;
    }

    // Проверяет правую диагональ на возможность блокировки следующего хода игрока. Возвращает координаты
    // поля, которое занимает компьютер
    public int[] checkRightDiagonalToBlock(char[][] ticTacToeArea, int chipsToWin, char playerChipX) {
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

    // Проверяет левую диагональ на возможность блокировки следующего хода игрока. Возвращает координаты
    // поля, которое занимает компьютер
    public int[] checkLeftDiagonalToBlock(char[][] ticTacToeArea, int chipsToWin, char playerChipX) {
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

    // Проверяет столбцы на возможность блокировки следующего хода игрока. Возвращает координаты
    // поля, которое занимает компьютер
    public int[] checkColumnsToBlock(char[][] ticTacToeArea, int chipsToWin, char emptyFieldArea, char playerChipX,
                                     char computerChipO) {
        for (int column = 0; column < ticTacToeArea.length; column++) {
            int row;
            row = getRowToBlock(ticTacToeArea, column, chipsToWin, emptyFieldArea, playerChipX, computerChipO);
            if (row != -1) {
                return new int[]{row + 1, column + 1};
            }
        }
        return new int[0];
    }

    // Проверяет строки на возможность блокировки следующего хода игрока. Возвращает координаты
    // поля, которое занимает компьютер
    public int[] checkRowsToBlock(char[][] ticTacToeArea, int chipsToWin, char emptyFieldArea, char playerChipX,
                                  char computerChipO) {
        for (int row = 0; row < ticTacToeArea.length; row++) {
            int column;
            column = getColumnToBlock(ticTacToeArea, row, chipsToWin, emptyFieldArea, playerChipX, computerChipO);
            if (column != -1) {
                return new int[]{row + 1, column + 1};
            }
        }
        return new int[0];
    }

    // Получает номер столбца, который необходимо заполнить в строке чтобы заблокировать последний ход игрока для
    // выигрыша. Возвращает координату поля в строке
    public int getColumnToBlock(char[][] ticTacToeArea, int row, int chipsToWin, char emptyFieldArea, char playerChipX,
                                char computerChipO){
        int columnBlock = -1;
        int countChipsX = 0;
        for (int column = 0; column < ticTacToeArea.length; column++) {
            if (ticTacToeArea[row][column] == emptyFieldArea) {
                columnBlock = column;
            }
            if (ticTacToeArea[row][column] == playerChipX) {
                countChipsX++;
            }
            if (ticTacToeArea[row][column] == computerChipO){
                continue;
            }
            if (countChipsX == chipsToWin - 1) return columnBlock;
        }
        return -1;
    }

    // Получает номер строки, которую необходимо заполнить в столбце чтобы заблокировать последний ход игрока для
    // выигрыша. Возвращает координату поля в столбце
    public int getRowToBlock(char[][] ticTacToeArea, int column, int chipsToWin, char emptyFieldArea, char playerChipX,
                                char computerChipO){
        int rowBlock = -1;
        int countChipsX = 0;
        for (int row = 0; row < ticTacToeArea.length; row++) {
            if (ticTacToeArea[row][column] == emptyFieldArea) {
                rowBlock = row;
            }
            if (ticTacToeArea[row][column] == playerChipX) {
                countChipsX++;
            }
            if (ticTacToeArea[row][column] == computerChipO){
                continue;
            }
            if (countChipsX == chipsToWin - 1) return rowBlock;
        }
        return -1;
    }

}
