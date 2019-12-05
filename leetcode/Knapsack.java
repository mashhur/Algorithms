package leetcode;

public class Knapsack {

    static int knapSack(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
        else {
            int val1 = val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1);
            int val2 = knapSack(W, wt, val, n - 1);
            return Math.max(val1, val2);
        }
    }

    public static void main(String args[]) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 45;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
