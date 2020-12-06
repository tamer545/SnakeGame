package gui;

import actions.KeyHandler;
import game.Snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Draw extends JLabel {

    Point p;
    Point p2;

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
            g.fillRect(p.x, p.y, 32, 32);
        }
        //Draw Snake Head
        g.setColor(new Color(66, 135, 245));
        p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
        g.fillRect(p.x, p.y, 32, 32);

        //Draw PickUp
        g.setColor(new Color(0, 0, 0));
        p = Snake.ptc(Snake.pickUp.getX(), Snake.pickUp.getY());
        p2 = Snake.ptc(Snake.pickUp.getX2(), Snake.pickUp.getY2());
        g.fillRect(p.x, p.y, 32, 32);

        if (KeyHandler.isDoubleFoodModeOn) {
            g.fillRect(p2.x, p2.y, 32, 32);
        }

        //Draw grid
        g.setColor(Color.GRAY);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                g.drawRect(i * 32 + Gui.xoff, j * 32 + Gui.yoff, 32, 32);
            }
        }

        //Draw border
        g.setColor(Color.BLACK);
        g.drawRect(Gui.xoff, Gui.yoff, 512, 512);

        //Draw Score
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + Snake.score, 5, 25);
        g.drawString("Highscore: " + Snake.bestScore, 705, 25);

        //Draw Shortcuts
        g.setFont(new Font("Arial", Font.ITALIC, 13));
        g.drawString("1: Ultra-Fast Mode", 5, 75);
        g.drawString("2: Slow-Mode", 5, 125);
        g.drawString("3: Ultra-Slow Mode", 5, 175);
        g.drawString("4: Add a Tail ", 5, 225);
        g.drawString("5: Double-Food Mode", 5, 275);
        g.drawString("9: Standard-Mode", 5, 375);


        repaint();
    }
}
