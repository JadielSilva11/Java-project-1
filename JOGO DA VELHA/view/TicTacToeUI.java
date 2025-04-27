package view;

import javax.swing.*;
import java.awt.*;

import controller.GameLogic;
import controller.ComputerPlayer;
import languages.LanguageManager;

public class TicTacToeUI extends JFrame {
    private final JButton[][] buttons = new JButton[3][3];
    private final String[][] board = new String[3][3];
    private boolean turn = true;
    private boolean vesusIA = false;

    public TicTacToeUI(){
        GameMode();
        DesignUI();
    }

    private void GameMode(){
        String[] modes = {
            LanguageManager.get("game.singleplayer"),
            LanguageManager.get("game.multiplayer")
        };

        int choice = JOptionPane.showOptionDialog(this,
                     LanguageManager.get("game.chooseMode"),
                     LanguageManager.get("game.title"),
                     JOptionPane.DEFAULT_OPTION,
                     JOptionPane.QUESTION_MESSAGE,
                     null,
                     modes,
                     modes[0]);

        vesusIA = (choice == 0);
    }

    private void DesignUI(){
        setTitle(LanguageManager.get("game.title"));
        setSize(300, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        Font font = new Font("Arial", Font.BOLD, 60);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j] = new JButton("");
                board[i][j] = "";
                buttons[i][j].setFont(font);
                final int lin = i, col = j;

                buttons[i][j].addActionListener(e ->{
                    if(!buttons[lin][col].getText().equals("")) return;

                    String currentPlayer = turn ? "X" : "O";
                    buttons[lin][col].setText(currentPlayer);
                    board[lin][col] = currentPlayer;

                    if(GameLogic.checkWinner(board, currentPlayer)){
                        showEndDialog(LanguageManager.get("game.win").replace("{0}", currentPlayer));
                        return;
                    }

                    if(GameLogic.isFull(board)){
                        showEndDialog(LanguageManager.get("game.draw"));
                        return;
                    }

                    turn = !turn;

                    if(vesusIA && !turn){
                        Point aiMove = ComputerPlayer.getMove(board);
                        if(aiMove != null){
                            buttons[aiMove.x][aiMove.y].doClick();
                        }
                    }
                });

                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    private void showEndDialog(String message){
        int option = JOptionPane.showOptionDialog(this, message + "\n" + LanguageManager.get("game.playAgain"),
                     LanguageManager.get("game.title"),
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE,
                     null,
                     new Object[]{
                        LanguageManager.get("game.yes"),
                        LanguageManager.get("game.no")
                     },
                     LanguageManager.get("game.yes"));

        if(option == JOptionPane.YES_OPTION){
            dispose();
            new TicTacToeUI();
        }
        else{
            System.exit(0);
        }
    }
}
