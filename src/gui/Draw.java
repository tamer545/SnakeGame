package gui;

import actions.KeyHandler;
import game.Snake;

import javax.swing.*;
import java.awt.*;


public class Draw extends JLabel {

    Point p;
    Point p2;
    Point p3;
    Point p4;
    Point p5;
    public static int snakeThickness = 20;


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, Gui.width, Gui.height);

        //Draw Snake Tails
        g.setColor(new Color(115, 199, 245));
        for (int i = 0; i < Snake.tails.size(); i++) {
            p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
            g.fillRect(p.x, p.y, snakeThickness, snakeThickness);
        }
        //Draw Snake Head
        g.setColor(new Color(66, 135, 245));
        p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
        g.fillRect(p.x, p.y, snakeThickness, snakeThickness);

        //Draw PickUp
        g.setColor(new Color(0, 0, 0));
        p = Snake.ptc(Snake.pickUp.getX(), Snake.pickUp.getY());
        p2 = Snake.ptc(Snake.pickUp.getX2(), Snake.pickUp.getY2());

        g.fillRect(p.x, p.y, snakeThickness, snakeThickness);

        if (KeyHandler.isDoubleFoodModeOn) {
            g.fillRect(p2.x, p2.y, snakeThickness, snakeThickness);
        }

        //Draw grid
        if (snakeThickness == 32) {
            g.setColor(Color.GRAY);
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    g.drawRect(i * 32 + Gui.xoff, j * 32 + Gui.yoff, 32, 32);
                }
            }
        }

        //Draw border
        g.setColor(Color.BLACK);
        if (!KeyHandler.isNoneBorderModeOn) {
            g.drawRect(Gui.xoff, Gui.yoff, 512, 512);
        }

        //Draw Score
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + Snake.score, 5, 25);
        g.drawString("Highscore: " + Snake.bestScore, 705, 25);

        //Draw Shortcuts
        g.setFont(new Font("Arial", Font.ITALIC, 13));
        g.drawString("0: Fast Mode", 5, 75);
        g.drawString("1: Ultra-Fast Mode", 5, 125);
        g.drawString("2: Slow-Mode", 5, 175);
        g.drawString("3: Ultra-Slow Mode", 5, 225);
        g.drawString("4: Double-Food Mode", 5, 275);
        g.drawString("5: None-Border Mode", 5, 325);
        g.drawString("6: Thin-Snake Mode", 5, 375);
        g.drawString("7: Extreme-Thin-Snake Mode", 5, 425);
        g.drawString("8: Thick-Snake Mode", 5, 475);
        g.drawString("9: Standard-Mode", 5, 525);


        repaint();
    }
}
