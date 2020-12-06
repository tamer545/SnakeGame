package clocks;

import actions.Collision;
import game.Snake;

import java.io.IOException;

public class GameClock extends Thread {
    public static boolean running = true;

    public void run() {
        while (running) {
            try {
                sleep(Collision.getSleepTime());
                Snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();

                if (Collision.collideSelf()) {
                    Snake.writeFile();
                    Snake.tails.clear();
                    Snake.score = 0;
                }
                if (Collision.collideWall()) {
                    Snake.writeFile();
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.score = 0;
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
