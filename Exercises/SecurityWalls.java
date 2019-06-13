package Exercises;

import java.util.ArrayList;
import java.util.List;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class SecurityWalls {

    /**
     * 0 0 0 0 0 0 0
     * 0 s 0 0 0 s 0
     * 0 0 w 0 s w 0
     * <p>
     * 2 1 2 0 0 0 0
     * 1 s 1 2 1 s 0
     * 2 1 w 1 s w 0
     **/

    public static void main(String[] args) {
        SecurityWalls securityWalls = new SecurityWalls();

        List<Point> securities = new ArrayList<>();
        securities.add(new Point(1, 1));
        securities.add(new Point(1, 5));

        List<Point> walls = new ArrayList<>();
        walls.add(new Point(2, 2));
        walls.add(new Point(2, 5));

        int[][] grid = new int[3][7];

        securityWalls.calcShortestPath(grid, securities, walls);
    }

    private void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void calcShortestPath(int[][] grid, List<Point> securities, List<Point> walls) {
        print(grid);
        for (Point point : securities) {
            grid[point.x][point.y] = 's';
            checkForNeighbours(grid, point.x++, point.y);
            checkForNeighbours(grid, point.x--, point.y);
            checkForNeighbours(grid, point.x, point.y--);
            checkForNeighbours(grid, point.x, point.y++);
        }

        for (Point point : walls) {
            grid[point.x][point.y] = 'w';

            checkForNeighbours(grid, point.x++, point.y);
            checkForNeighbours(grid, point.x--, point.y);
            checkForNeighbours(grid, point.x, point.y--);
            checkForNeighbours(grid, point.x, point.y++);
        }
        System.out.println(" --- Result --- ");
        print(grid);
    }

    private void checkForNeighbours(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                grid[i][j] == 's' || grid[i][j] == 'w')
            return;

        grid[i][j] = 1;
    }
}
