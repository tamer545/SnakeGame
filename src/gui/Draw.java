package gui;

import game.Snake;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    Point p;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw background
        g.setColor(new Color(84, 123, 140));
        g.fillRect(0, 0, Gui.width, Gui.height);

        //Draw Snake Tails
        g.setColor(new Color(51, 204, 51));
        for (int i = 0; i < Snake.tails.size(); i++) {
            p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
            g.fillRect(p.x, p.y, 20, 20);
        }
        //Draw Snake Head
        g.setColor(new Color(0, 150, 0));
        p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
        g.fillRect(p.x, p.y, 20, 20);

        //Draw PickUp
        g.setColor(new Color(204, 51, 0));
        p = Snake.ptc(Snake.pickUp.getX(), Snake.pickUp.getY());
        g.fillRect(p.x, p.y, 20, 20);

        //Draw grid
        g.setColor(Color.GRAY);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                //g.drawRect(i * 32 + Gui.xoff, j * 32 + Gui.yoff, 20, 20);
            }
        }

        //Draw border
        g.setColor(Color.BLACK);
        g.drawRect(Gui.xoff, Gui.yoff, 512, 512);

        //Draw Score
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + Snake.score, 5, 25);
        g.drawString("Highscore: " + Snake.bestScore, 655, 25);

        //Draw Shortcuts
        g.setFont(new Font("Arial", Font.ITALIC, 13));
        g.drawString("1: Ultra-Fast Mode", 5, 75);
        g.drawString("2: Slow-Mode", 5, 125);
        g.drawString("3: Ultra-Slow Mode", 5, 175);
        g.drawString("9: Standard-Mode", 5, 225);

        repaint();
    }
}
