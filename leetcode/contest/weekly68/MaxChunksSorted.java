package leetcode.contest.weekly68;

// Max Chunks To Make Sorted I
public class MaxChunksSorted {

    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 0) return 0;

        int sum = arr[0];
        int chunks = 1;

        for (int i = 1; i < arr.length; i++) {
            if (sum == 0) chunks++;
            sum += arr[i] - i;
        }
        return chunks;
    }
}
