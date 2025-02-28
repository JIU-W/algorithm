package com.itjn.hash;

import java.util.Arrays;

public class 相等行列对 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        int i = equalPairs(arr);
        System.out.println(i);
    }

    //方法一：模拟 + 暴力
    public static int equalPairs(int[][] grid) {
        int count = 0, n = grid.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (isEqual(row, col, grid, n)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isEqual(int row, int col, int[][] grid, int length) {
        for (int i = 0; i < length; i++) {
            if(grid[row][i] != grid[i][col])
                return false;
        }
        return true;
    }

    //方法二：



}
