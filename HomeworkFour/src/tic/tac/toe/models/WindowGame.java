package tic.tac.toe.models;

import tic.tac.toe.handlers.GameHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowGame extends JFrame {

   private JFrame welcomeFrame;
   private GridLayout gameGridLayout;
   private JLabel welcomeTextLabel;
   private JButton startGameButton;
   private JButton[][] gameButtons;

   Area area;
   Player player;
   Computer computer;

   public WindowGame() {
      welcomeFrame = new JFrame();
      welcomeTextLabel = new JLabel();
      startGameButton = new JButton();
   }

   public void onInitWindow(){

      area = new Area();
      player = new Player();
      computer = new Computer(area.getSizeArea());

      area.setNewArea();

      welcomeFrame.setBounds(500, 125, 300, 300);
      welcomeFrame.setResizable(false);
      welcomeFrame.setTitle("Tic-tac-toe game");
      welcomeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

      gameGridLayout = new GridLayout(5, 5);
      welcomeFrame.setLayout(gameGridLayout);
      gameButtons = new JButton[5][5];
      for (int row = 0; row < gameButtons.length; row++)
         for (int column = 0; column < gameButtons.length; column++){
            gameButtons[row][column] = new JButton(String.valueOf(area.getEmptyFieldArea()));
            gameButtons[row][column].setName((row + 1) + " " + (column + 1));
            System.out.println(gameButtons[row][column].getName());
            gameButtons[row][column].addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  JButton button = (JButton) e.getSource();
                  playerGetMove(button);
               }
            });
            welcomeFrame.add(gameButtons[row][column]);
         }
      welcomeFrame.setVisible(true);
   }

   private void playerGetMove(JButton button) {
      int[] cell = new int[2];
      int index = 0;
      for (int symbolIterator = 0; symbolIterator < button.getName().length(); symbolIterator++) {
         if (button.getName().charAt(symbolIterator) != ' '){
            cell[index] = Integer.parseInt(Character.toString(button.getName().charAt(symbolIterator)));
            index++;
         }
      }

      System.out.println(cell.toString());

      button.setText(String.valueOf(player.getChipX()));

      area.setMove(cell[GameHandler.FIRST_ELEMENT], cell[GameHandler.SECOND_ELEMENT], player.getChipX());

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

   }

   public void computerMove() {
      int[] move;
      move = computer.getMove(
              area.getSizeArea(),
              area.getTicTacToeArea(),
              area.getEmptyFieldArea(),
              area.getChipsToWin(),
              player.getChipX());
      gameButtons[move[GameHandler.FIRST_ELEMENT] - 1][move[GameHandler.SECOND_ELEMENT] - 1].setText(String.valueOf(computer.getChipO()));
      area.setMove(move[GameHandler.FIRST_ELEMENT], move[GameHandler.SECOND_ELEMENT], computer.getChipO());
   }

}
