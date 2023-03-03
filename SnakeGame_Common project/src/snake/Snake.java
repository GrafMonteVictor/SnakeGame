package snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private int x;
    private int y;

    public boolean isAlive = true;
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private int eatedPart = -1;
    private List<GameObject> snakeParts = new ArrayList<>();

    private Direction direction = Direction.LEFT;
    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        if (isAlive == true) {
            for (int i = 0; i < snakeParts.size(); i++) {
                int xElement = snakeParts.get(i).x;
                int yElement = snakeParts.get(i).y;
                if (i == 0) {
                    game.setCellValueEx(xElement, yElement, Color.NONE, HEAD_SIGN, Color.BLACK, 75);
                } else {
                    game.setCellValueEx(xElement, yElement, Color.NONE, BODY_SIGN, Color.BLACK, 75);
                }
            }
        }
    }

    public void  setDirection(Direction direction) {
        if ((this.direction == Direction.UP && direction == Direction.DOWN)
            || (this.direction == Direction.DOWN && direction == Direction.UP)
            || (this.direction == Direction.RIGHT && direction == Direction.LEFT)
            || (this.direction == Direction.LEFT && direction == Direction.RIGHT)) {
            return;
        }

        if ((this.direction == Direction.LEFT && snakeParts.get(0).x == snakeParts.get(1).x)
            || (this.direction == Direction.RIGHT && snakeParts.get(0).x == snakeParts.get(1).x)
            || (this.direction == Direction.UP && snakeParts.get(0).y == snakeParts.get(1).y)
            || (this.direction == Direction.DOWN && snakeParts.get(0).y == snakeParts.get(1).y)) {
            return;
        }
        this.direction = direction;
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();
        boolean collision = checkCollision(newHead);
        if (collision == true) {
            removeBody();
        }
        snakeParts.add(0, newHead);

        if (apple.x == newHead.x && apple.y == newHead.y) {
            apple.isAlive = false;
            addTail();
        }
        else {
            removeTail();
        }

//        for (Apple apple2: line.getLineApple()) {
//            if (apple2.x == newHead.x && apple2.y == newHead.y) {
//                apple2.isAlive = false;
//                addTail();
//            }
//        }

    }

    public GameObject createNewHead() {
        int xHead = snakeParts.get(0).x;
        int yHead = snakeParts.get(0).y;
        switch (direction) {
            case UP:
                if (yHead <= 0 ) {
                    return new GameObject(xHead, SnakeGame.HEIGHT - 1);
                }
                return new GameObject(xHead, yHead - 1);
            case DOWN:
                if (yHead >= SnakeGame.HEIGHT - 1 ) {
                    return new GameObject(xHead, 0);
                }
                return new GameObject(xHead,yHead + 1);
            case LEFT:
                if (xHead <= 0 ) {
                    return new GameObject(SnakeGame.WIDTH - 1, yHead);
                }
                return new GameObject(xHead - 1, yHead);
            case RIGHT:
                if (xHead >= SnakeGame.WIDTH - 1) {
                    return new GameObject(0, yHead);
                }
        }
        return new GameObject(xHead + 1, yHead);
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject object) {
        for (int i = 0; i < snakeParts.size(); i++) {
            if (object.x == snakeParts.get(i).x
                && object.y == snakeParts.get(i).y) {
                this.eatedPart = i;
                return true;
            }
        }
        return false;
    }

    private void addTail() {
        int xTail = snakeParts.get(snakeParts.size()-1).x;
        int yTail = snakeParts.get(snakeParts.size()-1).y;
        int xPreTail = snakeParts.get(snakeParts.size()-2).x;
        int yPreTail = snakeParts.get(snakeParts.size()-2).y;
        if (xTail > xPreTail) {
            snakeParts.add(new GameObject((xTail + 1), yTail));
        } else if (xTail < xPreTail) {
            snakeParts.add(new GameObject((xTail - 1), yTail));
        } else if (yTail > yPreTail) {
            snakeParts.add(new GameObject(xTail, yTail + 1));
        } else if (yTail < yPreTail) {
            snakeParts.add(new GameObject(xTail, yTail - 1));
        }
    }
    public int getLength() {
        return snakeParts.size();
    }

    private void removeBody() {
        for (int j = snakeParts.size(); j >= eatedPart; j--) {
            snakeParts.remove(snakeParts.size() - 1);
        }
    }
}
