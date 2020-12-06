package start;

import clocks.GameClock;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreenView extends JFrame{
    private JButton STARTButton;
    private JPanel mainPanel;

    public StartScreenView() {
        super("AutoClicker");
        setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850, 600);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        STARTButton.addActionListener(e -> {
            Gui gui = new Gui();
            GameClock gc = new GameClock();

            gui.create();
            gc.start();

            setVisible(false);
        });
    }

}
