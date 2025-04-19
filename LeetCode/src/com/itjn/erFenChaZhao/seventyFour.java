package com.itjn.erFenChaZhao;

import java.util.Arrays;

public class seventyFour {
    public static void main(String[] args) {
        boolean b = searchMatrix1(new int[][]{{1}}, 1);
        System.out.println(b);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while(l <= r){
            int mid = (l + r) >> 1;
            int x = matrix[mid / n][mid % n];
            if(target == x){
                return true;
            }else if(target < x){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }

    //二刷
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int[] arr = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                arr[index++] = anInt;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        int i = Arrays.binarySearch(arr, target);
        if(i < 0){
            return false;
        }
        return true;
    }

}
