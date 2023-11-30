package src;

import javax.swing.*;

public class SnakeGame {
    public static void main(String[] args) throws Exception {
        int boardwidth = 600;
        int boardheight = boardwidth;
        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardwidth, boardheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SnakeGame1 snakegame1 = new SnakeGame1(boardwidth, boardheight);
        frame.add(snakegame1);
        frame.pack();
        snakegame1.requestFocus();
    }
}
