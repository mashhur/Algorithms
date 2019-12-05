package exercises;

public class ArrayRotation {

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        if (K >= A.length) {
            K = K % A.length;
        }

        if (K == 0) {
            return A;
        }

        int[] a = new int[A.length];

        for (int i=0; i < A.length; i++) {
            if (i < K) {
                a[i] = A[A.length-K+i];
            } else {
                a[i] = A[i-K];
            }
        }

        return a;
    }
}
