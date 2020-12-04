package actions;

import clocks.GameClock;
import gui.Gui;

public class Main {

    public static void main(String[] args) {
        Gui gui = new Gui();
        GameClock gameClock = new GameClock();

        gui.create();
        gameClock.start();
    }
}
