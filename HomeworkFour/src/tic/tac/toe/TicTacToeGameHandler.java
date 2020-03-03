package tic.tac.toe;

public class TicTacToeGameHandler {

    public static final int FIRST_ELEMENT = 0;
    public static final int SECOND_ELEMENT = 1;

    public static void pressEnterKeyToContinue() {
        System.out.print("Для продолжения нажмите Enter...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public static boolean checkWin(char[][] ticTacToeArea, int chipsToWin, char chip) {
        return (isRowWin(ticTacToeArea, chipsToWin, chip) || isColumnWin(ticTacToeArea, chipsToWin, chip) ||
            isLeftDiagonalWin(ticTacToeArea, chipsToWin, chip) || isRightDiagonalWin(ticTacToeArea, chipsToWin, chip));
    }

    private static boolean isLeftDiagonalWin(char[][] ticTacToeArea, int chipsToWin, char chip) {
        int startPositionToFail = ticTacToeArea.length / chipsToWin; // Количество итераций цикла
        int countCycleIteration = ticTacToeArea.length % chipsToWin;       // Начальная позиция проверки выигрыша
        int numberLastElement = ticTacToeArea.length - 1;                  // Номер последнего элемента в массиве

        for (int rowFail = startPositionToFail; rowFail <= countCycleIteration * 2; rowFail++) {
            if((ticTacToeArea[rowFail][rowFail] != chip) |
                    (ticTacToeArea[numberLastElement - rowFail][numberLastElement - rowFail] != chip)) {
                break;
            }
            int countLeft = 0;
            for (int row = 0; row < ticTacToeArea.length; row++) {
                if (ticTacToeArea[row][row] == chip) countLeft++;
            }
            if (countLeft >= chipsToWin) return true;
        }
        return false;
    }

    private static boolean isRightDiagonalWin(char[][] ticTacToeArea, int chipsToWin, char chip) {
        int startPositionToFail = ticTacToeArea.length / chipsToWin; // Количество итераций цикла
        int countCycleIteration = ticTacToeArea.length % chipsToWin;       // Начальная позиция проверки выигрыша
        int numberLastElement = ticTacToeArea.length - 1;                  // Номер последнего элемента в массиве

        for (int rowFail = startPositionToFail; rowFail <= countCycleIteration * 2; rowFail++) {
            if((ticTacToeArea[rowFail][numberLastElement - rowFail] != chip) |
                    (ticTacToeArea[numberLastElement - rowFail][rowFail] != chip)) {
                break;
            }
            int countRight = 0;
            for (int row = 0; row < ticTacToeArea.length; row++) {
                if (ticTacToeArea[row][numberLastElement - row] == chip) countRight++;
            }
            if (countRight >= chipsToWin) return true;
        }
        return false;
    }

    private static boolean isColumnWin(char[][] ticTacToeArea, int chipsToWin, char chip) {
        int count;
        int startPositionToFail = ticTacToeArea.length / chipsToWin; // Количество итераций цикла
        int countCycleIteration = ticTacToeArea.length % chipsToWin;       // Начальная позиция проверки выигрыша
        int numberLastElement = ticTacToeArea.length - 1;                  // Номер последнего элемента в массиве
        for (int column = 0; column < ticTacToeArea.length; column ++) {
            for (int rowFail = startPositionToFail; rowFail <= startPositionToFail * 2; rowFail++) {
                if ((ticTacToeArea[rowFail][column] != chip) |
                        (ticTacToeArea[numberLastElement - rowFail][column] != chip)) {
                    break;
                }
                count = 0;
                for (int row = 0; row < ticTacToeArea.length; row++) {
                    if (ticTacToeArea[row][column] == chip) count++;
                }
                if (count >= chipsToWin) return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(char[][] ticTacToeArea, int chipsToWin, int chip) {
        int count;
        int startPositionToFail = ticTacToeArea.length / chipsToWin; // Начальная позиция проверки выигрыша
        int countCycleIteration = ticTacToeArea.length % chipsToWin;       // Количество итераций цикла
        int numberLastElement = ticTacToeArea.length - 1;                  // Номер последнего элемента в массиве
        for (int row = 0; row < ticTacToeArea.length; row ++) {
            for (int columnFail = startPositionToFail; columnFail <= startPositionToFail * 2; columnFail++) {
                if ((ticTacToeArea[row][columnFail] != chip) ||
                        (ticTacToeArea[row][numberLastElement - columnFail] != chip)) {
                    break;
                }
                count = 0;
                for (int column = 0; column < ticTacToeArea.length; column++) {
                    if (ticTacToeArea[row][column] == chip) count++;
                }
                if (count >= chipsToWin) return true;
            }
        }
        return false;
    }

    public static boolean isCellValid(int[] move, char[][] ticTacToeArea, int sizeArea, char emptyFieldArea) {
        int row = move[0], column = move[1];
        if ((row < 1 || row > sizeArea) || (column < 1 || column > sizeArea)) {
            return false;
        }
        if (ticTacToeArea[row - 1][column - 1] != emptyFieldArea) {
            return false;
        }
        return true;
    }

    public static boolean isAreaFull(char[][] area, int sizeArea, char emptyFieldArea) {
        for (int i = 0; i < sizeArea; i++) {
            for (int j = 0; j < sizeArea; j++) {
                if (area[i][j] == emptyFieldArea) return false;
            }
        }
        return true;
    }

}
