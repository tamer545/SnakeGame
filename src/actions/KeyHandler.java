package actions;

import clocks.GameClock;
import game.Direction;
import game.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public static boolean isDoubleFoodModeOn = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (!(Snake.head.getDirection() == Direction.DOWN) && !Snake.waitToMove) {
                    Snake.head.setDirection(Direction.UP);
                    Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (!(Snake.head.getDirection() == Direction.UP) && !Snake.waitToMove) {
                    Snake.head.setDirection(Direction.DOWN);
                    Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (!(Snake.head.getDirection() == Direction.RIGHT) && !Snake.waitToMove) {
                    Snake.head.setDirection(Direction.LEFT);
                    Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (!(Snake.head.getDirection() == Direction.LEFT) && !Snake.waitToMove) {
                    Snake.head.setDirection(Direction.RIGHT);
                    Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_0:
                Collision.sleepTime = 100 - Snake.score * 2;
                break;
            case KeyEvent.VK_1:
                Collision.sleepTime = 50 - Snake.score * 2;
                break;
            case KeyEvent.VK_2:
                Collision.sleepTime = 400 - Snake.score * 2;
                break;
            case KeyEvent.VK_3:
                Collision.sleepTime = 999 - Snake.score * 2;
                break;
            case KeyEvent.VK_5:
                isDoubleFoodModeOn = true;
                break;
            case KeyEvent.VK_9:
                Collision.sleepTime = 200 - Snake.score * 2;
                isDoubleFoodModeOn = false;
                break;


        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
