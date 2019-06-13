package Exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SecurityWalls {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    List<Point> securities;
    List<Point> walls;
    int[][] grid;

    public void initialize() {
        securities = new ArrayList<>();
        securities.add(new Point(1, 1));
        securities.add(new Point(1, 5));

        walls = new ArrayList<>();
        walls.add(new Point(2, 2));
        walls.add(new Point(2, 5));

        grid = new int[3][7];
    }

    /**
     * 0 0 0 0 0 0 0
     * 0 s 0 0 0 s 0
     * 0 0 w 0 s w 0
     * <p>
     * 2 1 2 3 2 1 2
     * 1 s 1 2 1 s 1
     * 2 1 w 1 s w 1
     **/

    public static void main(String[] args) {
        SecurityWalls securityWalls = new SecurityWalls();
        securityWalls.initialize();

        securityWalls.calcShortestPath();
    }

    private void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void calcShortestPath() {
        Queue<Point> queue = new LinkedList<>();

        for (Point point : securities) {
            grid[point.x][point.y] = 's';
            queue.add(point);
        }
        for (Point point : walls) {
            grid[point.x][point.y] = 'w';
            queue.add(point);
        }

        print(grid);

        // BFS
        while (queue.isEmpty() == false) {
            Point point = queue.remove();

            int distance = 0;
            int backCol = point.x - 1;
            int forwardCol = point.x + 1;
            int forwardRow = point.y - 1;
            int backRow = point.y + 1;
            checkForNeighbours(grid, backCol, point.y, distance);
            checkForNeighbours(grid, forwardCol, point.y, distance);
            checkForNeighbours(grid, point.x, backRow, distance);
            checkForNeighbours(grid, point.x, forwardRow, distance);
        }

        System.out.println(" --- Result --- ");
        print(grid);
    }

    private void checkForNeighbours(int[][] grid, int i, int j, int distance) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) // grid boundary validation
            return;
        if (grid[i][j] == 's' || grid[i][j] == 'w') // security or wall
            return;
        if (grid[i][j] != 0 && grid[i][j] <= distance) // already visited and calculated distance
            return;

        distance++;
        grid[i][j] = distance;
        print(grid);

        int backCol = i - 1;
        int forwardCol = i + 1;
        int forwardRow = j - 1;
        int backRow = j + 1;
        checkForNeighbours(grid, backCol, j, distance);
        checkForNeighbours(grid, forwardCol, j, distance);
        checkForNeighbours(grid, i, backRow, distance);
        checkForNeighbours(grid, i, forwardRow, distance);
    }
}
