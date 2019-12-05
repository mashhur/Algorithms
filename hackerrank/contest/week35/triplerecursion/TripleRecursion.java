package hackerrank.contest.week35.triplerecursion;

import java.util.Scanner;

/**
 * Created by mashhur on 11/17/17.
 */
public class TripleRecursion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        tripleRecursion(n, m, k);
        in.close();
    }

    private static void tripleRecursion(int n, int m, int k) {
        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // 1. if i=j=0 then array[i][j]=m
                    array[i][j] = m;
                } else if (i == j) {
                    // 2. if i=j then array[i][j]=array[i-1][j-1]+k
                    array[i][j] = array[i - 1][j - 1] + k;
                } else if (i > j) {
                    // 3. if i>j then array[i][j]=array[i-1][j]-1
                    array[i][j] = array[i - 1][j] - 1;
                } else if (i < j) {
                    // 4. if i<j then array[i][j]=array[i][j-1]-1
                    array[i][j] = array[i][j - 1] - 1;
                }
            }
        }

        print(array);
    }

    private static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
