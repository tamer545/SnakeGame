package game;

import java.util.concurrent.ThreadLocalRandom;

public class PickUp {
    int x, y;

    public PickUp() {
        this.x = ThreadLocalRandom.current().nextInt(0, 15);
        this.y = ThreadLocalRandom.current().nextInt(0, 15);

    }

    public void reset() {
        this.x = ThreadLocalRandom.current().nextInt(0, 15);
        this.y = ThreadLocalRandom.current().nextInt(0, 15);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
