package leetcode.contest.weekly56;

/**
 * Created by mashhur on 10/29/17.
 */
public class MaxSubArray {

    public static void main(String args[]) {
        int A[] = {1,2,3,2,1};
        int B[] = {3,2,1,4,7};
        // output: 3,2,1

        //int A[] = {0,1,1,1,0};
        //int B[] = {1,1,1,1,1};
        // output: 3

        //int A[] = {0,0,0,0,0,0,1,0,0,0};
        //int B[] = {0,0,0,0,0,0,0,1,0,0};
        // output: 9
        System.out.println(findLength1(A,B));
    }

    public static int findLength(int[] A, int[] B) {
        int max = 0;

        for (int i=0; i<A.length; i++) {
            System.out.println("Cycle: " + i);
            int j=0;
            while (j<B.length && A[i] != B[j]) j++;

            if(j != B.length) {
                int idx = i;
                int current = 1; i++; j++;
                while (i<A.length && j<B.length && A[i] == B[j]) {
                    i++; j++; current++;
                }
                max = Math.max(max, current);
                i = idx;
            }
        }

        return max;
    }

    public static int findLength1(int[] A, int[] B) {
        if(A == null||B == null) return 0;

        int max = 0;
        //dp[i][j] is the length of longest common subarray ending with nums[i] and nums[j]
        int[][] dp = new int[A.length + 1][B.length + 1];
        for(int i = 0;i <= A.length;i++) {
            for(int j = 0;j <= B.length;j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{
                    if(A[i - 1] == B[j - 1]){
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max,dp[i][j]);
                    }
                }
            }
        }

        for (int i=0; i<A.length+1; i++) {
            for (int j=0; j<B.length+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return max;
    }

}
