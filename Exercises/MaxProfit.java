package Exercises;

// Kadane algorithm

public class MaxProfit {

    static int getMaxProfit() {
        int[] stocks = {7,1,5,3,6,4};


        // track the min
        // track the max change
        int min = stocks[0];
        int profit = 0;
        for (int i=0; i<stocks.length; i++) {
            if (min > stocks[i])
                min = stocks[i];
            profit = Math.max(profit, stocks[i]-min);
        }

        return profit;
    }


    static int calcDroneMinEnergy(int[][] route) {
        if (route.length <= 1)
            return 0;

        int max = Integer.MIN_VALUE;
        int energy = 0;
        for (int i=0; i<route.length-1; i++) {
            energy += route[i+1][2]-route[i][2]; // -9, -4, 5, -2
            if (max < energy) // -9, -4, 5, 5
                max = energy;
        }

        if (max < 0)
            max = 0;

        return max;
    }
}
