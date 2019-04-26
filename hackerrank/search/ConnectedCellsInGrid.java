package hackerrank.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mashhur on 2/17/17.
 */
public class ConnectedCellsInGrid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nArr[i][j] = sc.nextInt();
            }
        }
        //print(nArr,n,m);
        System.out.println(getMaxIsland(nArr, m, n));
    }

    static int getMaxIsland(int[][] nArr, int m, int n) {
        List<Integer> nIslands = new ArrayList<>();
        boolean[][] bVisit = new boolean[n][m];
        // DFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bVisit[i][j])
                    continue;

                if (nArr[i][j] == 1) {
                    int nCount = visit(nArr, i, j, n, m, bVisit);
                    if (nCount > 0)
                        nIslands.add(nCount);
                }
            }
        }

        Collections.sort(nIslands);

        return nIslands.size() > 0 ? nIslands.get(nIslands.size() - 1) : -1;
    }

    static boolean isSafe(int i, int j, int n, int m) {
        if (i < n && j < m && i >= 0 && j >= 0)
            return true;

        return false;
    }

    static int visit(int[][] nArr, int i, int j, int n, int m, boolean[][] bVisit) {
        int nCount = 0;
        int nNeigh[] = {-1, 0, 1};
        for (int k = 0; k < nNeigh.length; k++) {
            for (int l = 0; l < nNeigh.length; l++) {
                int y = j + nNeigh[k];
                int x = i + nNeigh[l];
                if (isSafe(x, y, n, m)) {
                    //System.out.println("X=" + x + "  Y=" + y);
                    if (bVisit[x][y])
                        continue;
                    bVisit[x][y] = true;

                    if (nArr[x][y] == 1) {
                        nCount++;
                        nCount += visit(nArr, x, y, n, m, bVisit);
                    }
                }
            }
        }
        return nCount;
    }

    static void print(int[][] nArr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(nArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
