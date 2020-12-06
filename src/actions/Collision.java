package actions;

import game.Snake;

public class Collision {
    public static int sleepTime = 200;

    public static boolean collideSelf() {
        for (int i = 0; i < Snake.tails.size(); i++) {
            if (Snake.head.getX() == Snake.tails.get(i).getX() && Snake.head.getY() == Snake.tails.get(i).getY() && !Snake.tails.get(i).isWait()) {
                sleepTime = 200;
                return true;
            }
        }

        return false;
    }

    public static boolean collideWall() {
        if (Snake.head.getX() < 0 || Snake.head.getX() > 15 || Snake.head.getY() < 0 || Snake.head.getY() > 15) {
            sleepTime = 200;
            return true;
        }
        return false;
    }

    public static void collidePickUp() {
        if (Snake.head.getX() == Snake.pickUp.getX() && Snake.head.getY() == Snake.pickUp.getY()) {
            Snake.pickUp.reset();
            pickUp();
        }
    }

    public static void collideSecondPickUp() {
        if (Snake.head.getX() == Snake.pickUp.getX2() && Snake.head.getY() == Snake.pickUp.getY2()) {
            Snake.pickUp.resetDoubleFoodMode();
            pickUp();
        }
    }

    public static void pickUp() {
        Snake.addTail();
        Snake.score += 1;
        sleepTime -= 2;

        if (Snake.score > Snake.bestScore) {
            Snake.bestScore = Snake.score;
        }
    }

    public static int getSleepTime() {
        return sleepTime;
    }


}
