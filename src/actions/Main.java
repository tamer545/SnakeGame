package actions;

import clocks.GameClock;
import gui.Gui;

public class Main {

    public static void main(String[] args) {
        Gui gui = new Gui();
        GameClock gc = new GameClock();

        gui.create();
        gc.start();
    }
}
