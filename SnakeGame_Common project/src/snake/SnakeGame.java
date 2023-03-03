package snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

public class SnakeGame extends   Game {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    private int score;
    private int turnDelay;
    private boolean isGameStopped;

    private Snake snake;
    private Apple apple;
    private Letter letter;
    private static final int GOAL = 31;
    private List<Line> lineList = new ArrayList<>();
    private List<Apple> listApple = new ArrayList<>();

    private boolean flag = false;
    //private final Line VERTICAL =  createVerticalLine(10,10);
//    private final Line HORIZONTAL = new Line(x, y, addApple(x, y, WIDTH));

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        score = 0;
        setScore(score);
        turnDelay = 50;
        setTurnTimer(turnDelay);
        snake = new Snake(WIDTH/2, HEIGHT/2);
        createNewApple();
        isGameStopped = false;
        //listApple = createH(10, 10);
        drawScene();
    }

    @Override
    public void onTurn(int turnDelay) {
        if (flag == false) {
            try {
                printCongratulation();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        snake.move(apple);
        if (apple.isAlive == false) {
            createNewApple();
            score += 1;
            setScore(score);
            this.turnDelay -= 2;
            setTurnTimer(this.turnDelay);
        }

        if (snake.isAlive == false) {
            gameOver();
        }
        if (snake.getLength() >= GOAL) {
            win();
        }
        drawScene();
    }

    private void createNewApple() {
        apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        while (snake.checkCollision(apple)) {
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        }
    }

    private Line createVerticalLine(int x, int y) {
        Line line = new Line(x, y);
        List<Apple> listApple = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            listApple.add(new Apple(x, y + i));
        }
        line.setLineApple(listApple);
        return line;
    }


    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(i, j, Color.WHITE, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
//        for (Apple apple: listApple) {
//            apple.draw(this);
//        }
        //VERTICAL.draw(this);
    }

    private void printCongratulation() throws InterruptedException {
        //showMessageDialog(Color.NONE, "Happy Birthday, Dashka!\nНажми пробэл", Color.ORANGE, 30);
        Thread.sleep(1000);
        flag = true;
    }
    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) {
            createGame();
        }
        switch (key) {
            case UP:
                snake.setDirection(Direction.UP);
                break;
            case DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
        }
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "GAME OVER", Color.RED, 50);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "Молодец! Возьми голубец", Color.GREEN, 30);
    }

    private List<Apple> createH(int x, int y) {
        //create vertical
        List<Apple> listApple = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listApple.add(new Apple(x, y + i));
        }
        return listApple;
    }

}
