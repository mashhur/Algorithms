package hackerrank;

import java.util.Scanner;

/**
 * Created by mashhur on 11/12/16.
 */
public class SameDigits {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int nArr[] = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = scan.nextInt();

            char[] chArr = String.valueOf(nArr[i]).toCharArray();
            int nXOR = chArr[0];
            for (int k = 1; k < chArr.length; k++) {
                nXOR ^= chArr[k];
            }

            if (nXOR != 0)
                System.out.println(nArr[i]);
        }
    }
}
