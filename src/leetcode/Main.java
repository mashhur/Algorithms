package leetcode;

import java.util.Scanner;

/**
 * Created by mashhur on 10/22/17.
 */
public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        NumberComplement(sc.nextInt());
        //System.out.println(findComplement(sc.nextInt()));
    }

    // straightforward way
    public static void NumberComplement(int n) {
        boolean bStart = false;
        for (int i=31; i>=0; i--) {
            if ((n & 1 << i) != 0)
                bStart = true;
            if (bStart)
                n ^= 1 << i;
        }
        System.out.println(n);
    }

    // interesting way
    public static int findComplement(int num) {
        int i = 0;
        int j = 0;

        while (i < num) {
            i += Math.pow(2, j);
            j++;
        }

        return i - num;
    }
}
