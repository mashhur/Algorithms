package exercises;

import java.util.LinkedList;
import java.util.Queue;

public class NearestPostOffice {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 0 0 P 0 0 0 0
     * 0 0 0 0 0 P 0
     * 0 0 P 0 0 0 0
     * <p>
     * 2 1 P 1 2 1 2
     * 3 2 1 2 1 P 1
     * 2 1 P 1 2 1 2
     **/

    private void bfs(int[][] grid) {
        print(grid);

        Queue<Point> offices = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'P')
                    offices.add(new Point(i, j));
            }
        }

        while (offices.isEmpty() == false) {
            Point office = offices.remove();
            bfs(office.x, office.y, grid);
        }
    }

    void bfs(int col, int row, int[][] grid) {
        int distance = 0;
        int forwardCol = col + 1;
        int backCol = col - 1;
        int forwardRow = row + 1;
        int backRow = row - 1;

        visitNeighbours(forwardCol, row, grid, distance);
        visitNeighbours(backCol, row, grid, distance);
        visitNeighbours(col, backRow, grid, distance);
        visitNeighbours(col, forwardRow, grid, distance);
    }

    private void visitNeighbours(int col, int row, int[][] grid, int distance) {
        if (col < 0 || col >= grid.length || row < 0 || row >= grid[col].length)
            return;
        if (grid[col][row] == 'P')
            return;
        if (grid[col][row] != 0 && grid[col][row] <= distance)
            return;

        distance++;
        grid[col][row] = distance;

        print(grid);

        int forwardCol = col + 1;
        int backCol = col - 1;
        int forwardRow = row + 1;
        int backRow = row - 1;

        visitNeighbours(forwardCol, row, grid, distance);
        visitNeighbours(backCol, row, grid, distance);
        visitNeighbours(col, backRow, grid, distance);
        visitNeighbours(col, forwardRow, grid, distance);
    }

    private void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 'P', 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 'P', 0},
                {0, 0, 'P', 0, 0, 0, 0}
        };

        NearestPostOffice office = new NearestPostOffice();
        office.bfs(grid);
    }

}
