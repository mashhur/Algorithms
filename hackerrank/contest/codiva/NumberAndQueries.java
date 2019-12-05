package hackerrank.contest.codiva;

import java.util.Scanner;

/**
 * Created by mashhur on 11/25/17.
 */
public class NumberAndQueries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int startVal = in.nextInt();
            int endVal = in.nextInt();
            int result = maxDifference(startVal, endVal);
            System.out.println(result);
        }
        in.close();
    }

    static int maxDifference(int startVal, int endVal) {
        int temp = startVal;
        int minPrime = 0;

        while (temp < endVal) {
            if (isPrime(temp)) {
                minPrime = temp;
                break;
            }
            temp++;
        }

        if (minPrime == 0) {
            return 0;
        }

        int maxPrime = minPrime;
        temp = endVal;
        while (temp > minPrime) {
            if (isPrime(temp)) {
                maxPrime = temp;
                break;
            }
            temp--;
        }

        return maxPrime - minPrime;
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
