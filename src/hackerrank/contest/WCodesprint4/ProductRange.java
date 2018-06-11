package hackerrank.contest.WCodesprint4;

import java.util.Scanner;

/**
 * Created by mashhur on 10/28/17.
 */
public class ProductRange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            int answer = productOfPages(a, b, c, d, p, q);
            System.out.println(answer);
        }
        in.close();
    }

    static int productOfPages(int a, int b, int c, int d, int p, int q) {
        if(p == a) { p=1; a=1; }
        if(q == a) { q=1; a=1; }
        if(p == b) { p=1; b=1; }
        if(q == b) { q=1; b=1; }
        if(p == c) { p=1; c=1; }
        if(q == c) { q=1; c=1; }
        if(p == d) { p=1; d=1; }
        if(q == d) { q=1; d=1; }
        // Return the product of the page counts of the missing books
        return a*b*c*d*p*q;
    }

}
