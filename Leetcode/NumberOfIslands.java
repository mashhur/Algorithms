package Leetcode;

public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();

        char[][] grid = {{'1', '1', '1' }, {'0', '1', '0' }, {'1', '1', '1' }};
        System.out.println(islands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    visitNeighbours(i, j, grid);
                }
            }
        }

        return count;
    }

    private void visitNeighbours(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0' || grid[i][j] == '-')
            return;

        grid[i][j] = '-';
        System.out.println(); // "i:" + i + ", j:" + j
        print(grid);

        visitNeighbours(i + 1, j, grid);
        visitNeighbours(i - 1, j, grid);
        visitNeighbours(i, j + 1, grid);
        visitNeighbours(i, j - 1, grid);

    }

    void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
