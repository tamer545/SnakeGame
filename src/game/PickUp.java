package game;

import actions.KeyHandler;

import java.util.concurrent.ThreadLocalRandom;

public class PickUp {
    int x, y;
    int x2, y2;
    int x3, y3;
    int x4, y4;
    int x5, y5;

    public PickUp() {
        this.x = ThreadLocalRandom.current().nextInt(0, 15);
        this.y = ThreadLocalRandom.current().nextInt(0, 15);

        if (KeyHandler.isDoubleFoodModeOn) {
            this.x2 = ThreadLocalRandom.current().nextInt(0, 15);
            this.y2 = ThreadLocalRandom.current().nextInt(0, 15);
        }
    }

    public void reset() {
        this.x = ThreadLocalRandom.current().nextInt(0, 15);
        this.y = ThreadLocalRandom.current().nextInt(0, 15);
    }

    public void resetDoubleFoodMode() {
        this.x2 = ThreadLocalRandom.current().nextInt(0, 15);
        this.y2 = ThreadLocalRandom.current().nextInt(0, 15);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

}
