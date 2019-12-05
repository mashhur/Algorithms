package leetcode.contest.weekly59.drivingnumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mashhur on 11/19/17.
 */
public class SelfDrivingNumber {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDrivingNumber(i))
                list.add(i);
        }
        return list;
    }

    public static boolean isSelfDrivingNumber(int number) {
        int remain = number;
        while (remain > 9) {
            int current = remain;
            remain = remain / 10;
            int digit = current - remain * 10;

            // Not contains ZERO
            // Every number it consist has to be divisible
            if (digit == 0 || number % digit != 0) return false;
        }

        if (remain == 0 || number % remain != 0) return false;
        return true;
    }
}
