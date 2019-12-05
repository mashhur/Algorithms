package assessments.beamin;

import java.util.Arrays;

public class Analyze {

    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }

    public static void main(String[] args) {
        Analyze analyze = new Analyze();
        //int[] A = {1, 3, 2, 1};
        //int[] B = {4, 2, 5, 3, 2};

        //int[] A = {2, 1};
        //int[] B = {3, 3};

        int[] B = {10, 10, 10, 10, 13};
        int[] A = {1, 2, 3, 13};
        System.out.println(analyze.solution(A,B));
    }

}