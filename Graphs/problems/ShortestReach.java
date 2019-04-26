package Graphs.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by mashhur on 1/31/17.
 */

public class ShortestReach {
    /*
        // 1st test case
        2
        4 2
        1 2
        1 3
        1
        3 1
        2 3
        2

        // 2nd test case
        1
        10 6
        3 1
        10 1
        10 1
        3 1
        1 8
        5 2
        3
    * */

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            int[][] nMat = new int[n][n];

            int m = sc.nextInt();
            for (int k = 0; k < m; k++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                // add edge
                nMat[u][v] = 1;
                nMat[v][u] = 1;
            }

            int[] nDistance = new int[n];

            int idx = sc.nextInt() - 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(idx);

            boolean[] nVisit = new boolean[n];
            nVisit[idx] = true;

            while (!queue.isEmpty()) {
                int nStartIdx = queue.poll();
                //System.out.println("Start idx: " + (nStartIdx+1));
                int[] nChildArr = nMat[nStartIdx];
                for (int x = 0; x < nChildArr.length; x++) {
                    if (nChildArr[x] == 1 && !nVisit[x]) {
                        //System.out.println("Child idx: " + (x+1));
                        nDistance[x] = nDistance[nStartIdx] + 6;
                        queue.add(x);
                        nVisit[x] = true;
                    }
                }
            }

            for (int k = 0; k < n; k++) {
                if (k == idx) continue;
                if (nDistance[k] > 0)
                    System.out.print(nDistance[k] + " ");
                else
                    System.out.print("-1 ");
            }
            System.out.println();
        }
    }
}
