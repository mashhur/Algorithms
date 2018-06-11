package hackerrank.contest.w34;

import java.util.*;

/**
 * Created by mashhur on 7/20/17.
 */
public class OnceInTrain {

    static String onceInATram(int x) {
        x++;
        while (getDigitsSum(x, true) != getDigitsSum(x, false)) {
            x++;
        }

        return String.valueOf(x);
    }

    static int getDigitsSum(int n, boolean bDiv) {
        int s;
        if(bDiv)
            s = n / 1000;
        else
            s = n % 1000;
        int n3 = s % 10;
        int n2 = (s % 100) / 10;
        int n1 = s / 100;
        return  n1+n2+n3;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        if(x < Math.pow(10, 5) || x > (Math.pow(10, 6) - 2))
            return;

        String result = onceInATram(x);
        System.out.println(result);
    }
}
