import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.io.*;
import java.util.Scanner;

public class TicTacToe extends JPanel implements ActionListener {
    boolean playerX;
    boolean gameDone = false;
    int winner = -1;
    int player1wins = 0, player2wins = 0;
    int board[][] = new int[3][3];

    int lineWidth = 5;
    int linelength = 270;
    int x = 15, y = 100;
    int offset = 95, a = 0, b = 5, selX = 0, selY = 0;
    // colors///
    Color turtle = new Color(0x80bdab);
    Color orange = new Color(0xfdcb9e);
    Color offwhite = new Color(0xf7f7f7);
    Color darkgray = new Color(0x3f3f44);

    JButton jButton;

    public TicTacToe() {
        Dimension size = new Dimension(420, 300);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        jButton = new JButton("play Again ? ");
        jButton.addActionListener(this);
        jButton.setVisible(false);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TicTacToe ");
        frame.getContentPane();
        TicTacToe tPanel = new TicTacToe();
        frame.add(tPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        resetGame();
    }

    public JButton getJButton() {
        return jButton;
    }

    public void setPlayer1wins(int a) {
        player1wins = a;
    }

    public void setPlayer2wins(int a) {
        player2wins = a;
    }

    public void resetGame() {
        playerX = true;
        winner = -1;
        gameDone = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
        getJButton().setVisible(false);
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        drawBoard(page);
        draawUI(page);
        // drawGame(page);
    }

    public void drawBoard(Graphics page) {
        setBackground(turtle);
        page.setColor(darkgray);
        page.fillRoundRect(x, y, linelength, lineWidth, 5, 30);
        page.fillRoundRect(x, y + offset, linelength, lineWidth, 5, 30);
        page.fillRoundRect(y, x, lineWidth, linelength, 30, 5);
        page.fillRoundRect(y + offset, x, lineWidth, linelength, 30, 5);
    }

    public void draawUI(Graphics page) {
        page.setColor(darkgray);
        page.fillRect(300, 0, 120, 300);
        Font font = new Font("Helvetica", Font.PLAIN, 20);
        page.setFont(font);

        page.setColor(offwhite);
        page.drawString("Win Count ", 310, 30);
        page.drawString(": " + player1wins, 360, 70);
        page.drawString(": " + player2wins, 362, 105);

        ImageIcon xIcon = new ImageIcon("orangex.png");
        Image xImg = xIcon.getImage();
        Image newXImg = xImg.getScaledInstance(27, 27, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newXIcon = new ImageIcon(newXImg);
        page.drawImage(newXIcon.getImage(), 329, 47, null);

        page.setColor(offwhite);
        page.fillOval(328, 80, 30, 30);
        page.setColor(darkgray);
        page.fillOval(334, 85, 19, 19);

        page.setColor(offwhite);
        Font font1 = new Font("Serif", Font.ITALIC, 18);
        page.setFont(font1);
        if (gameDone) {
            if (winner == 1) {
                page.drawString("The Winner is ", 310, 150);
                page.drawImage(xImg, 335, 160, null);
            } else if (winner == 2) {
                page.drawString("The winner is ", 310, 150);
                page.setColor(offwhite);
                page.fillOval(332, 160, 50, 50);
                page.fillOval(342, 170, 30, 30);
            } else if (winner == 3) {
                page.drawString("It is a tie ", 330, 178);
            }
        } else {
            Font font2 = new Font("Serif ", Font.ITALIC, 20);
            page.setFont(font2);
            page.drawString("It's ", 350, 160);
            if (playerX) {
                page.drawString("X's turn ", 325, 180);

            } else {
                page.drawString("O's turn ", 325, 180);
            }
        }

    }
}
