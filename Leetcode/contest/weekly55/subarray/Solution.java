package Leetcode.contest.weekly55.subarray;

/**
 * Created by mashhur on 10/24/17.
 */
public class Solution {

    public static void main(String args[]) {
        //int nums[] = {10, 5, 2, 6};
        //int k = 100;
        // answer : 8

        int nums[] = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;
        // answer : 18

        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length < 1) return 0;

        int result = 0;
        int right = 0;
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) continue;

            if (right <= i) { // release multiplication point
                prod = 1;
                right = i;
            }

            // find the place where product less then k
            while (right < nums.length && prod * nums[right] < k) {
                //System.out.println(nums[right]);
                prod *= nums[right];
                right++;
            }
            prod = prod / nums[i];
            result += right - i;

        }

        return result;
    }
}
