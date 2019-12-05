package leetcode.contest.weekly68;

public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];
                int m = i + 1, k = j + 1;
                while (m < matrix.length && k < matrix[i].length) {
                    if (value != matrix[m][k])
                        return false;
                    m++;
                    k++;
                }
            }
        }
        return true;
    }
}
