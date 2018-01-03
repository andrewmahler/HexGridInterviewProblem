/*
Name: Andrew Mahler
Email: amahler@wisc.edu
 */

import java.util.*;

public class Interview {

    private static List<Solution> wordSearch(HexGrid puzzle, List<String> wordList) {
        ArrayList<Solution> solutions = new ArrayList<Solution>();

        // states the furthest away 2 points could be, for hex distance of 1 this would be 2
        int totalDistance = puzzle.distanceFromOrigin - (puzzle.distanceFromOrigin * -1);
        // if distance is 1, starts iteration at (-1,-1)... 2 would be (-2,-2)
        int x = (puzzle.distanceFromOrigin * -1);
        int y = (puzzle.distanceFromOrigin * -1);

        // loops through each possible starting point
        for (int i = 0; i < ((totalDistance + 1) * (totalDistance + 1)); i++) {
            /* but makes sure that we don't check the points that aren't in the graph, for example
            I saw that the points whose coordinates added to 0 were not in the graph, except for the origin of course
             */
            if ((x + y) != 0 || ((x == 0) && (y == 0))) {
                // creates a string of the coordinates so the hashmap can be accessed
                StringBuilder coord = new StringBuilder("");
                coord.append("" + x + "," + y);

                // each direction
                // directions range from 1-6
                int direction = 1;
                for (int dir = 0; dir < 6; dir++) {
                    int tempX = x;
                    int tempY = y;

                    // North
                    if (direction == 1) {
                        StringBuilder checker = new StringBuilder("");
                        checker.append(puzzle.grid.get(coord.toString()));

                        tempY--;
                        // StringBuilder for coordinate updating
                        StringBuilder trav = new StringBuilder("" + tempX + "," + tempY);

                        while (puzzle.grid.get(trav.toString()) != null) {
                            checker.append(puzzle.grid.get(trav.toString()));

                            tempY--;
                            trav = new StringBuilder("" + tempX + "," + tempY);
                        }
                        if (wordList.contains(checker.toString())) {
                            Solution solution = new Solution(x, y, checker.toString(), Solution.Direction.North);
                            solutions.add(solution);
                        }
                    // Northeast
                    } else if (direction == 2) {
                        StringBuilder checker = new StringBuilder("");
                        checker.append(puzzle.grid.get(coord.toString()));

                        tempX++;
                        // StringBuilder for coordinate updating
                        StringBuilder trav = new StringBuilder("" + tempX + "," + tempY);

                        while (puzzle.grid.get(trav.toString()) != null) {
                            checker.append(puzzle.grid.get(trav.toString()));

                            tempX++;
                            trav = new StringBuilder("" + tempX + "," + tempY);
                        }
                        if (wordList.contains(checker.toString())) {
                            Solution solution = new Solution(x, y, checker.toString(), Solution.Direction.Northeast);
                            solutions.add(solution);
                        }
                    // Southeast
                    } else if (direction == 3) {
                        StringBuilder checker = new StringBuilder("");
                        checker.append(puzzle.grid.get(coord.toString()));

                        tempX++;
                        tempY++;
                        // StringBuilder for coordinate updating
                        StringBuilder trav = new StringBuilder("" + tempX + "," + tempY);

                        while (puzzle.grid.get(trav.toString()) != null) {
                            checker.append(puzzle.grid.get(trav.toString()));

                            tempX++;
                            tempY++;
                            trav = new StringBuilder("" + tempX + "," + tempY);
                        }
                        if (wordList.contains(checker.toString())) {
                            Solution solution = new Solution(x, y, checker.toString(), Solution.Direction.Southeast);
                            solutions.add(solution);
                        }
                    // South
                    } else if (direction == 4) {
                        StringBuilder checker = new StringBuilder("");
                        checker.append(puzzle.grid.get(coord.toString()));

                        tempY++;
                        // StringBuilder for coordinate updating
                        StringBuilder trav = new StringBuilder("" + tempX + "," + tempY);

                        while (puzzle.grid.get(trav.toString()) != null) {
                            checker.append(puzzle.grid.get(trav.toString()));

                            tempY++;
                            trav = new StringBuilder("" + tempX + "," + tempY);
                        }
                        if (wordList.contains(checker.toString())) {
                            Solution solution = new Solution(x, y, checker.toString(), Solution.Direction.South);
                            solutions.add(solution);
                        }
                    // Southwest
                    } else if (direction == 5) {
                        StringBuilder checker = new StringBuilder("");
                        checker.append(puzzle.grid.get(coord.toString()));

                        tempX--;
                        // StringBuilder for coordinate updating
                        StringBuilder trav = new StringBuilder("" + tempX + "," + tempY);

                        while (puzzle.grid.get(trav.toString()) != null) {
                            checker.append(puzzle.grid.get(trav.toString()));

                            tempX--;
                            trav = new StringBuilder("" + tempX + "," + tempY);
                        }
                        if (wordList.contains(checker.toString())) {
                            Solution solution = new Solution(x, y, checker.toString(), Solution.Direction.Southwest);
                            solutions.add(solution);
                        }
                    // Northwest
                    } else if (direction == 6) {
                        StringBuilder checker = new StringBuilder("");
                        checker.append(puzzle.grid.get(coord.toString()));

                        tempX--;
                        tempY--;
                        // StringBuilder for coordinate updating
                        StringBuilder trav = new StringBuilder("" + tempX + "," + tempY);

                        while (puzzle.grid.get(trav.toString()) != null) {
                            checker.append(puzzle.grid.get(trav.toString()));

                            tempX--;
                            tempY--;
                            trav = new StringBuilder("" + tempX + "," + tempY);
                        }
                        if (wordList.contains(checker.toString())) {
                            Solution solution = new Solution(x, y, checker.toString(), Solution.Direction.Northwest);
                            solutions.add(solution);
                        }
                    }
                    direction++;
                }
            }
            //update x and y
            /* increments x until it runs over, then increments y, this makes sure that
            each coordinate is touched
             */
            x++;
            if (x > puzzle.distanceFromOrigin) {
                y++;
                x = (puzzle.distanceFromOrigin * -1);
            }
        }
        return solutions;
    }
    public static void main(String args[]) {
        HashMap test = new HashMap();
        // testing with distance from origin of 1
        test.put("-1,-1", 'e');
        test.put("0,0", 'd');
        test.put("1,1", 'r');
        test.put("-1,0", 'a');
        test.put("1,0", 'l');
        test.put("0,1", 'y');
        test.put("0,-1", 'u');

        test.put("0,-2", 'c');
        test.put("-1,-2", 'b');
        test.put("-2,-2", 'r');
        test.put("-2,-1", 'v');
        test.put("-2,0", 't');
        test.put("-1,1", 'r');
        test.put("0,2", 'x');
        test.put("1,2", 's');
        test.put("2,2", 'o');
        test.put("2,1", 'l');
        test.put("2,0", 'a');
        test.put("1,-1", 'q');

        ArrayList<String> wordList = new ArrayList<String>();
        wordList.add("bear");
        wordList.add("bull");
        HexGrid puzzle = new HexGrid(2, test);
        List<Solution> solutions = wordSearch(puzzle, wordList);
        for (Solution s : solutions) {
            System.out.println(s.toString());
        }
    }
}
