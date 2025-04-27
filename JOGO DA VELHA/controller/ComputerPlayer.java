package controller;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer {
    public static Point getMove(String[][] board){
        ArrayList<Point> empty = new ArrayList<>();

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j].equals("")){
                    empty.add(new Point(i, j));
                }
            }
        }

        if(empty.isEmpty()) return null;

        Random rand = new Random();
        return empty.get(rand.nextInt(empty.size()));
    }
}
