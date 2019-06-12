package Exercises;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SubsetSample {

    private void combination(int[] arr) {
        if (arr.length == 0)
            return;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(arr[0]);

        while (queue.isEmpty() == false) {
            int item = queue.remove();

        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3};

        SubsetSample subsetSample = new SubsetSample();
        subsetSample.combination(arr);
    }
}
