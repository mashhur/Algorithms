package greedy;

import java.util.Scanner;

/**
 * Created by mashhur on 1/30/17.
 */
public class TaumAndBday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();

            if (y > x && x + z < y) { // buy white & make it black
                long nDeal = x + z;
                System.out.println(b * x + w * nDeal);
            } else if (x > y && y + z < x) {
                long nDeal = y + z;
                System.out.println(w * y + b * nDeal);
            } else
                System.out.println(b * x + w * y);
        }
    }
}
