package Leetcode;

public class Mountain {

    public static int getMaxLengthOfMountain(int[] array) {
        if (array == null || array.length < 3)
            return 0;

        int max = 0;
        boolean isFound = false;
        int start = 0;
        for (int i=0; i<array.length - 1; i++) {
            if (array[i+1] > array[i] && isFound == false) { // mountain found
                isFound = true;
                start = i;
            }

            int delta = array[i+1] - array[i];
            if (delta < 0 && isFound == true) { // decrease
                while (i < array.length-1 && array[i+1] < array[i]) {
                    i++;
                }

                max = Math.max(max, i-start+1);
                isFound = false;
                i--;
                //[875,884,239,731,723,685]
            } else if (delta == 0) {
                isFound = false;
            }
        }

        return max;
    }
}
