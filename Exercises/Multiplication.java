package Exercises;

public class Multiplication {

    // input    [2,  7,  3,  4]
    // output   [84, 24, 56, 42]
    int[] multiplication(int[] arr) {
        if (arr.length <= 1)
            return new int[0];

        int[] result = new int[arr.length];
        int[] left = new int[arr.length + 1];
        int[] right = new int[arr.length + 1];

        left[0] = 1;
        right[0] = 1;

        for (int i=0; i<arr.length; i++) {
            left[i+1] = left[i]*arr[i];
            right[i+1] = right[i]*arr[arr.length - i - 1];
        }

        for (int i=0; i<arr.length; i++) {
            result[i] = left[i] * right[arr.length-i-1];
            System.out.print(result[i] + " ");
        }

        return result;
    }

    public static void main(String[] args) {
        Multiplication sample = new Multiplication();
        int[] arr = {2,  7,  3,  4};
        sample.multiplication(arr);
    }
}
