package Exercises;

public class PathExists {

    public boolean checkForPath(int[][] grid, int col, int row, int toCol, int toRow) {
        if (grid[col][row] == 0)
            return false;

        int backCol = col - 1;
        int nextCol = col + 1;
        int backRow = row - 1;
        int nextRow = row + 1;
        return visitNeighbors(grid, backCol, row, toCol, toRow) ||
                visitNeighbors(grid, nextCol, row, toCol, toRow) ||
                visitNeighbors(grid, col, backRow, toCol, toRow) ||
                visitNeighbors(grid, col, nextRow, toCol, toRow);
    }

    private boolean visitNeighbors(int[][] grid, int col, int row, int toCol, int toRow) {
        if (col < 0 || col >= grid.length || toCol < 0 || toCol >= grid.length)
            return false;
        if (col == toCol && row == toRow)
            return true;
        if (grid[col][row] == 0)
            return false;

        grid[col][row] = 0;

        int backCol = col - 1;
        int nextCol = col + 1;
        int backRow = row - 1;
        int nextRow = row + 1;
        return visitNeighbors(grid, backCol, row, toCol, toRow) ||
                visitNeighbors(grid, nextCol, row, toCol, toRow) ||
                visitNeighbors(grid, col, backRow, toCol, toRow) ||
                visitNeighbors(grid, col, nextRow, toCol, toRow);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        PathExists pathExists = new PathExists();
        System.out.println(pathExists.checkForPath(grid, 1, 1, 1, 4));
    }
}
