package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CutOffTrees {

    public static void main(String[] args) {
        CutOffTrees trees = new CutOffTrees();
        List<List<Integer>> grid = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(0);
        row1.add(3);
        grid.add(row1);

        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(0);
        row2.add(5);
        grid.add(row2);

        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(0);
        row3.add(1);
        grid.add(row3);

        System.out.println(trees.cutOffTree(grid));
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int[][] grid = convert(forest);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    print(grid);
                    grid[i][j] = -1;
                    int cuts = visitNeighbors(grid, i + 1, j) +
                            visitNeighbors(grid, i - 1, j) +
                            visitNeighbors(grid, i, j + 1) +
                            visitNeighbors(grid, i, j - 1);

                    for (int n = 0; n < grid.length; n++) {
                        for (int m = 0; m < grid[n].length; m++) {
                            if (grid[n][m] > 0)
                                return -1;
                        }
                    }

                    return cuts;
                }
            }
        }

        return -1;
    }

    private int visitNeighbors(int[][] grid, int col, int row) {
        if (col < 0 || col >= grid.length || row < 0 || row >= grid[col].length)
            return 0;
        if (grid[col][row] <= 1)
            return 0;

        int cut = grid[col][row] > 1 ? 1 : 0;
        grid[col][row] = -1;
        return cut +
                visitNeighbors(grid, col + 1, row) +
                visitNeighbors(grid, col - 1, row) +
                visitNeighbors(grid, col, row + 1) +
                visitNeighbors(grid, col, row - 1);
    }

    private int[][] convert(List<List<Integer>> forest) {
        int[][] grid = new int[forest.size()][forest.get(0).size()];
        int i = 0;
        for (List<Integer> part : forest) {
            int j = 0;
            for (int cell : part) {
                //System.out.print("i: " + i + ", j: " + j);
                grid[i][j] = cell;
                j++;
            }
            i++;
            //System.out.println();
        }
        return grid;
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
}