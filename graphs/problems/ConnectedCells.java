package graphs.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mashhur on 1/29/17.
 */
public class ConnectedCells {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(countIslands(grid, n, m));
    }

    static int countIslands(int M[][], int ROW, int COL) {
        boolean visited[][] = new boolean[ROW][COL];

        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j])
                    nList.add(DFS(M, i, j, visited, ROW, COL) + 1);
        }

        Collections.sort(nList);
        return nList.get(nList.size() - 1);
    }

    static int DFS(int M[][], int row, int col, boolean visited[][], int ROW, int COL) {
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        int nCount = 0;
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL)) {
                nCount += DFS(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL);
                nCount++;
            }

        return nCount;
    }

    static boolean isSafe(int M[][], int row, int col, boolean visited[][], int ROW, int COL) {
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (M[row][col] == 1 && !visited[row][col]);
    }
}
