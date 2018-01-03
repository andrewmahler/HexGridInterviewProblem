import java.util.*;

public class HexGrid {

    public final int distanceFromOrigin;
    public HashMap grid = new HashMap();
    public int totalNumSpots;

    public HexGrid(int distanceFromOrigin, HashMap grid) {
        // n by n grid, this is the n that the user specifies
        this.distanceFromOrigin = distanceFromOrigin;
        int numSpots = 1;
        // calculating total num spots in this hex grid
        for (int i = 1; i < distanceFromOrigin; i++) {
            numSpots += 6 * i;
        }
        this.totalNumSpots = numSpots;
        this.grid = grid;
    }
}
