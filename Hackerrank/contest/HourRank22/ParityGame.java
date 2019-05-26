package Hackerrank.contest.HourRank22;

import java.util.Scanner;

/**
 * Created by mashhur on 7/22/17.
 */
public class ParityGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];

        if (n == 0) {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        boolean bHasOddNumber = false;
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
            sum += A[i];
            if (A[i] % 2 != 0)
                bHasOddNumber = true;
        }

        if (n == 1) {
            if (A[0] % 2 != 0)
                System.out.println(-1);
            else
                System.out.println(0);
            return;
        }

        if (sum % 2 == 0) {
            System.out.println(0);
            return;
        } else if (sum <= 1) {
            System.out.println(-1);
            return;
        }

        if (bHasOddNumber) {
            System.out.println(1);
            return;
        }
    }
}
