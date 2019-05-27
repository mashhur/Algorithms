package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MaxRectangle {

    public static void main(String args[]) {
        MaxRectangle rectangle = new MaxRectangle();
        rectangle.solution(new int[4][4]);
    }

    public int solution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 1;
            }
        }

        board[0][0] = 0;
        board[3][1] = 0;
        board[3][0] = 0;
        board[3][3] = 0;

        // check if input data is valid
        print(board, board.length, board[0].length);

        // DFS
        // 1. Search connected components
        // 2. For each component validate & get size of rectangle
        // 3. Return the biggest one
        int result = getMaxIsland(board, board.length, board[0].length);
        System.out.println(result);
        return result;
    }

    int getMaxIsland(int[][] nArr, int m, int n) {
        List<Integer> nIslands = new ArrayList<>();
        boolean[][] bVisit = new boolean[n][m];
        // DFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bVisit[i][j])
                    continue;

                if (nArr[i][j] == 1 && isRectangle(nArr, i, j, m, n)) {
                    int nCount = visit(nArr, i, j, n, m, bVisit);
                    if (nCount > 0)
                        nIslands.add(nCount);
                }
            }
        }

        Collections.sort(nIslands);
        return nIslands.size() > 0 ? nIslands.get(nIslands.size() - 1) : -1;
    }

    boolean isRectangle(int[][] nArr, int i, int j, int m, int n) {
        if (isSafe(i, j, n, m))
            if ((nArr[i][j] != 1)) return false;

        if (isSafe(i - 1, j, n, m))
            if (nArr[i - 1][j] != 1) return false;

        if (isSafe(i, j - 1, n, m))
            if (nArr[i][j - 1] != 1) return false;

        if (isSafe(i - 1, j - 1, n, m))
            if (nArr[i - 1][j - 1] != 1) return false;

        return true;
    }

    boolean isSafe(int i, int j, int n, int m) {
        if (i < n && j < m && i >= 0 && j >= 0)
            return true;

        return false;
    }

    int visit(int[][] nArr, int i, int j, int n, int m, boolean[][] bVisit) {
        int nCount = 0;
        int nNeigh[] = {-1, 0, 1};
        for (int k = 0; k < nNeigh.length; k++) {
            for (int l = 0; l < nNeigh.length; l++) {
                int y = j + nNeigh[k];
                int x = i + nNeigh[l];
                if (isSafe(x, y, n, m)) {
                    if (bVisit[x][y])
                        continue;
                    bVisit[x][y] = true;

                    if (nArr[x][y] == 1 && isRectangle(nArr, i, j, m, n)) {
                        nCount++;
                        nCount += visit(nArr, x, y, n, m, bVisit);
                    }
                }
            }
        }
        return nCount;
    }

    void print(int[][] nArr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(nArr[i][j] + " ");
            }
            System.out.println();
        }
    }

}