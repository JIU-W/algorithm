package com.itjn.prefixAnd;

public class threeHundredAndFour {
    public static void main(String[] args) {

    }
    int[][] sums;

    public threeHundredAndFour(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sums = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        sum = sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1]
                + sums[row1][col1];
        return sum;
    }


}
