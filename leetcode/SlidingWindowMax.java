package leetcode;

public class SlidingWindowMax {

    /* Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
    /  Output: [3,3,5,5,6,7]
    Window position                   Max
        ---------------              -----
        [1  3  -1] -3  5  3  6  7      3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0)
            return new int[0];

        int[] result = new int[n - k + 1];

        int max = findMax(nums, 0, k - 1);
        for (int i = 0, j = k; j < n; i++, j++) {
            result[i] = max;
            if (nums[i] == max) {
                max = findMax(nums, i + 1, j);
            } else if (nums[j] > max) {
                max = nums[j];
            }
        }
        result[n - k] = max;
        return result;
    }

    int findMax(int[] nums, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int m = i; m <= j; m++)
            max = Math.max(max, nums[m]);
        return max;
    }

    public static void main(String[] args) {
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        //int[] nums = {1,3,-1,-3,5,3,6,7};
        //int k = 3;
        int[] nums = {1, -1};
        int k = 1;
        int[] result = slidingWindowMax.maxSlidingWindow(nums, k);
        for (int res : result)
            System.out.print(res + " ");
        System.out.println();
    }
}
