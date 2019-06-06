package cci;

import java.util.HashMap;
import java.util.Map;

public class TripleStep {

    Map<Integer, Integer> memo = new HashMap<>();

    int n1 = -1, n2 = -1, n3 = -1;

    // TODO: try with 3 vars with memoization
    public int ways(int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return 1;

        System.out.println(n);

        int nThird = 0;
        if(n3 == -1)
            n3 = ways(n - 3);
        nThird = n3;

        int nSecond = 0;
        if (n2 == -1)
            n2 = ways(n - 2);
        nSecond = n2;

        int nFirst = 0;
        if(n1 == -1)
            n1 = ways(n - 1);
        nFirst = n1;


        return nThird + nSecond + nFirst;
    }

    public int waysWithMap(int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return 1;

        System.out.println(n);

        int n1 = getFromMemo(n - 1);
        int n2 = getFromMemo(n - 2);
        int n3 = getFromMemo(n - 3);

        return n3 + n2 + n1;
    }

    /* memoization with Map */
    private int getFromMemo(int n) {
        if (memo.containsKey(n) == false)
            memo.put(n, waysWithMap(n));

        return memo.get(n);
    }

    public static void main(String[] args) {
        TripleStep stair = new TripleStep();
        int result = stair.ways(5);
        System.out.println("Result: " + result);
    }
}
