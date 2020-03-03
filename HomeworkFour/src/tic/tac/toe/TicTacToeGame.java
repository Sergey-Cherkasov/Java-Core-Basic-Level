package tic.tac.toe;

public class TicTacToeGame {

    static TicTacToeArea area = new TicTacToeArea();
    static TicTacToePlayer player = new TicTacToePlayer();
    static TicTacToeComputer computer = new TicTacToeComputer(area.getSizeArea());
    static final char EMPTY_CHAR = ' ';

    public static void main(String[] args) {
        int[] move;
        System.out.println("Предлагаю сыграть в игру \"Крестики-нолики\".");
        TicTacToeGameHandler.pressEnterKeyToContinue();
        area.initNewArea();
        printAreaHeader();
        printArea();
        do {
            playerMove();
            if (TicTacToeGameHandler.checkWin(  area.getTicTacToeArea(),
                                                area.getChipsToWin(),
                                                player.getChipX())) {
                System.out.println("Вы победили!");
                return;
            }
            if (TicTacToeGameHandler.isAreaFull(area.getTicTacToeArea(),
                                                area.getSizeArea(),
                                                area.getEmptyFieldArea())) {
                System.out.println("Ничья");
                return;
            }
            computerMove();
            if (TicTacToeGameHandler.checkWin(  area.getTicTacToeArea(),
                                                area.getChipsToWin(),
                                                computer.getChipO())) {
                System.out.println("Победил компьютер");
                return;
            }
            if (TicTacToeGameHandler.isAreaFull(area.getTicTacToeArea(),
                                                area.getSizeArea(),
                                                area.getEmptyFieldArea())) {
                System.out.println("Ничья");
                return;
            }
        } while (true);
    }

    public static void playerMove() {
        int[] move;
        move = player.getMove(area.getSizeArea(),area.getTicTacToeArea(),area.getEmptyFieldArea());
        area.setMove(move[TicTacToeGameHandler.FIRST_ELEMENT], move[TicTacToeGameHandler.SECOND_ELEMENT], player.getChipX());
        printAreaHeader();
        printArea();
    }

    public static void computerMove() {
        int[] move;
        move = computer.getMove(area.getSizeArea(),
                                area.getTicTacToeArea(),
                                area.getEmptyFieldArea(),
                                area.getChipsToWin(),
                                player.getChipX());
        area.setMove(move[TicTacToeGameHandler.FIRST_ELEMENT], move[TicTacToeGameHandler.SECOND_ELEMENT], computer.getChipO());
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
