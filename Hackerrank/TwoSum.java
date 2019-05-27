package Hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mashhur on 1/29/17.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {10, 40, 50, 30, 20};
        int[] res = twoSum(arr, 40);
        System.out.println(arr[res[0]]);
        System.out.println(arr[res[1]]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
