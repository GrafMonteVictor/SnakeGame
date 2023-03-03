package snake;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;


public class Letter {
    int x;
    int y;
    private final int HEIGHT = 14;
    private final int WIDTH = 10;

    //private final Line VERTICAL =  new Line(x, y, addApple(x, y, HEIGHT));
    //private final Line HORIZONTAL = new Line(x, y, addApple(x, y, WIDTH));

    private List<Line> lines = new ArrayList<>();

    public Letter(int x, int y, List<Line> lines) {
        this.x = x;
        this.y = y;
        this.lines = lines;
    }
//
//    public Line getVERTICAL() {
//        return VERTICAL;
//    }
//
//    public Line getHORIZONTAL() {
//        return HORIZONTAL;
//    }

    private  List<Apple> addApple(int x, int y, int end) {
        List<Apple> lineApple = new ArrayList<>();
        for (int i = 0; i < end; i++) {
            if (end == HEIGHT) {
                lineApple.add(new Apple(x, y + i));
            } else if (end == WIDTH) {
                lineApple.add(new Apple(x + i, y));
            }
        }
        return lineApple;
    }

    public void draw(Game game) {
        for (Line line: lines) {
            line.draw(game);
        }
    }
}

