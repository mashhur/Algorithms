package Codility;

import java.util.HashMap;
import java.util.Map;

public class NumberOccurrence {

    public static void main(String[] args) {

        NumberOccurrence instance = new NumberOccurrence();
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 5;
        array[3] = 9;
        array[4] = 9;

        System.out.println(instance.binarySolution(array, 5));
    }

    public int binarySolution(int[] array, int x) {
        int position = -1;
        if (array.length == 0) return position;

        int pivot = array.length / 2;
        int i = 0, k = array.length;

        while (i < k) {
            if (array[pivot] == x)
                return pivot;
            if (array[pivot] > x)
                k = pivot;
            else
                i = pivot;
            pivot = pivot % 2 == 0 ? pivot / 2 : (pivot + 1) / 2;
        }

        return position;
    }

    public int mapSolution(int[] array, int x) {
        //  <Number, Position>
        Map<Integer, Integer> occurrence = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            occurrence.put(array[i], i);
        }
        return occurrence.get(x) == null ? -1 : occurrence.get(x);
    }
}
