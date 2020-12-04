package gui;

import javax.swing.*;

public class Gui {
    private JFrame jf;
    private Draw draw;
    public static int width = 800, height = 600;
    public static int xoff = 130, yoff = 20;

    public void create(){
        jf = new JFrame("Snake");
        jf.setSize(width, height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setResizable(false);

        draw = new Draw();
        draw.setBounds(0, 0, width, height);
        draw.setVisible(true);

        jf.add(draw);
        jf.requestFocus();
        jf.setVisible(true);
    }
}
