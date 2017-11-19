package hackerrank.Contest.week35.threeDsurface;

import java.util.Scanner;

/**
 * Created by mashhur on 11/18/17.
 */
public class ThreeDimentionSurface {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for(int A_i = 0; A_i < H; A_i++){
            for(int A_j = 0; A_j < W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = surfaceArea(A, H, W);
        System.out.println(result);
        in.close();
    }

    static int surfaceArea(int[][] A, int H, int W) {
        int total = 0;
        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                total += getCost(A, i, j, H, W);
            }
        }

        return total;
    }

    static int getCost(int[][] A, int i, int j, int H, int W) {
        // initial cost
        int cost = 6;
        if(A[i][j] > 1)
            cost = A[i][j]*6 - (A[i][j]-1);

        // upper
        if(i-1 >= 0) {
            if(A[i-1][j] > A[i][j])
                cost = cost - A[i][j];
            else
                cost = cost - A[i-1][j];
        }

        // left
        if(j-1 >= 0) {
            if(A[i][j-1] > A[i][j])
                cost = cost - A[i][j];
            else
                cost = cost - A[i][j-1];
        }

        // right
        if(j+1 < W) {
            if(A[i][j+1] > A[i][j])
                cost = cost - A[i][j];
            else
                cost = cost - A[i][j+1];
        }

        // bottom
        if(i+1 < H) {
            if(A[i+1][j] > A[i][j])
                cost = cost - A[i][j];
            else
                cost = cost - A[i+1][j];
        }

        return cost;
    }
}
