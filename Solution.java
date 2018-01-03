import java.util.*;

public class Solution {
    public enum Direction {
        North,
        Northeast,
        Southeast,
        South,
        Southwest,
        Northwest
    }

    public final int x;
    public final int y;
    public final String word;
    public final Direction direction;

    public Solution(int x, int y, String word, Direction direction) {
        this.x = x;
        this.y = y;
        this.word = word;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" at (%d,%d) going %s",
                word,
                x,
                y,
                direction);
    }
}
