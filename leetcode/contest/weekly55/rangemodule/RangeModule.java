package leetcode.contest.weekly55.rangemodule;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mashhur on 10/26/17.
 */
class TestRangeModule {

    public static void main(String args[]) {
        int left = 0, right = 100;
        RangeModule obj = new RangeModule();
        obj.addRange(left, right);
        boolean param_2 = obj.queryRange(left, right);
        obj.removeRange(left, right);
    }
}

class RangeModule {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    TreeMap<Integer, Integer> map;

    Map<Integer, Boolean> hashMap;

    public RangeModule() {
        hashMap = new HashMap<>();
    }

    public void addRange(int left, int right) {
        min = Math.min(min, left);
        max = Math.max(max, right);
    }

    public boolean queryRange(int left, int right) {
        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE)
            return false;

        // quick search and find range start/stop positions
        if (left < min)
            min = left;


        return false;
    }

    public void removeRange(int left, int right) {

    }
}