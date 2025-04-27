package controller;

public class GameLogic {
        public static boolean checkWinner(String[][] board, String player){
            for(int i=0;i<3;i++){
                if(board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) return true;
                if(board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) return true;
            }

            return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                   (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
        }

        public static boolean isFull(String[][] board){
            for(String[] row : board){
                for(String cell : row){
                    if(cell.equals("")) return false;
                }
            }
            return true;
        }
}
