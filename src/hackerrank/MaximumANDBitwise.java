package hackerrank;

import java.util.Scanner;

/**
 * Created by mashhur on 2/8/17.
 */
public class MaximumANDBitwise {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println(getMaxAND(n,k));
        }
    }

    private static int getMaxAND(int n, int k) {
        if (((k - 1) | k) > n && k % 2 == 0)
            return k - 2;

        return k-1;
    }
}
