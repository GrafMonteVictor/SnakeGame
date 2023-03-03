package snake;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private int x;
    private int y;
    private final int HEIGHT = 14;
    private final int WIDTH = 10;
    private List<Apple> lineApple = new ArrayList<>();

    private static final String APPLE_SIGN = "\uD83C\uDF4E";

    public Line(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Game game) {
        for (int i = 0; i < lineApple.size(); i++) {
            int xApple = lineApple.get(i).x;
            int yApple = lineApple.get(i).y;
            game.setCellValueEx(xApple, yApple, Color.NONE, APPLE_SIGN, Color.RED, 75);
        }
    }

    public List<Apple> getLineApple() {
        return lineApple;
    }

    public void setLineApple(List<Apple> lineApple) {
        this.lineApple = lineApple;
    }
}
