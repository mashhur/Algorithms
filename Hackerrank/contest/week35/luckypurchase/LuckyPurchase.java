package Hackerrank.contest.week35.luckypurchase;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mashhur on 11/16/17.
 */
public class LuckyPurchase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for (int t = 0; t < n; t++) {
            String name = in.next();
            int value = in.nextInt();
            map.put(name, value);
        }

        in.close();
        System.out.println(getLaptop(map));
    }

    private static String getLaptop(Map<String, Integer> map) {
        String minBrandName = "-1";
        int minPrice = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minPrice > entry.getValue()) {
                // 1. num of 4s equal to num of 7s
                if (isValidPrice(entry.getValue())) {
                    minPrice = entry.getValue();
                    minBrandName = entry.getKey();
                    //System.out.println(minBrandName);
                }
                // ELSE we don't need to consider higher price
            }
        }

        return minBrandName;
    }

    private static boolean isValidPrice(int val) {
        int fours = 0;
        int sevens = 0;

        int remain = val;
        while (remain >= 10) {
            int curr_num = remain;
            remain /= 10;
            int num = curr_num - remain * 10;
            if (num == 4) fours++;
            if (num == 7) sevens++;
            if (num != 4 || num != 7)
                return false;
        }

        if (remain == 4) fours++;
        if (remain == 7) sevens++;

        if (sevens == 0 || fours == 0)
            return false;
        return sevens == fours ? true : false;
    }
}
