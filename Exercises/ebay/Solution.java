package Exercises.ebay;

class Solution {

    // Time complexity : O(N)
    // Space complexity: O(1)
    public long linear(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long sum = 0;
        for (int i=1; i<n; i++) {
            sum += (i * (n+1));
        }

        return sum;
    }

    public long recursive(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return helper(n-1, n);

        /*
        2)
            1*2 + 1
        3)
            1*3 + 1
            2*3 + 2
        4)
            1*4 + 1
            2*4 + 2
            3*4 + 3
        5)
            1*5 + 1
            2*5 + 2
            3*5 + 3
            4*5 + 4

            i*n + i
        */
    }

    long helper(long m, long n) {
        if (m == 0)
            return 0;
        return (m*n + m) + helper(m-1, n);
    }

    private void temp() {
        char[] arr = null;

    }
}
