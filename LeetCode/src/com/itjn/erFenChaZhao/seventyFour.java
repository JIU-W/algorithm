package com.itjn.erFenChaZhao;

public class seventyFour {
    public static void main(String[] args) {
        boolean b = searchMatrix(new int[][]{{1},{3}}, 3);
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


}
