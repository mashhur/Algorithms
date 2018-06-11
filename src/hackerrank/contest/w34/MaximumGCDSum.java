package hackerrank.contest.w34;

import java.util.*;

/**
 * Created by mashhur on 7/20/17.
 */
public class MaximumGCDSum {
    /* Test case
      5
      3 1 4 2 8
      5 2 12 8 3
    */

    public static int gcd(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a % b);
    }

    static int maximumGcdAndSum(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        if (A[A.length-1] > B[B.length-1])
            return helper(B,A);
        else
            return helper(A,B);
    }

    static int helper(int[] A, int[] B) {
        int max = 0;
        int result = 0;
        Map<Integer, Integer> hMapA = new HashMap<>();

        for (int i = A.length-1; i>=(int)Math.sqrt(A.length); i--) {
            // skip if element is less then current max GCD
            if(A[i] <= max) break;

            // skip if already same value considered
            Integer iA = hMapA.get(A[i]);
            if(iA != null) continue;
            hMapA.put(A[i], A[i]);

            Map<Integer, Integer> hMapB = new HashMap<>();
            for (int j = B.length-1; j>=(int)Math.sqrt(B.length); j--) {

                // and skip if element is less then current max GCD
                if(B[j] <= max || A[i] <= max) break;

                // skip if already same value considered
                Integer iB = hMapB.get(B[j]);
                if(iB != null) continue;
                hMapB.put(B[j], B[j]);

                int g = gcd(A[i], B[j]);
                //System.err.println("GCD: " + g);

                if (g > max) {
                    max = g;
                    result = A[i] + B[j];
                } else if(g == max) {
                    if(result < A[i] + B[j])
                        result = A[i] + B[j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = in.nextInt();
        }

        int[] B = new int[n];
        for(int i = 0; i < n; i++){
            B[i] = in.nextInt();
        }

        int res = maximumGcdAndSum(A, B);
        System.out.println(res);
    }
}