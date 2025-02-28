package com.itjn.hash;

import java.util.*;

public class 相等行列对 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{11, 1}, {1, 11}};
        int i = equalPairs1(arr);
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
            if (grid[row][i] != grid[i][col])
                return false;
        }
        return true;
    }

    //方法二：哈希表(字符串数据类型作为map的key)
    public static int equalPairs1(int[][] grid) {
        int count = 0, n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        for (int[] arr : grid) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i);
                sb.append("-"); //加个"-"用来分开字符，且可以标识。
                                //不加的话，类似{11, 1}, {1, 11}的这种特殊情况就会误判。
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]);
                sb.append("-");
            }
            String s = sb.toString();
            if(map.containsKey(s)){
                count += map.get(s);
            }
        }

        return count;
    }

    //方法三：哈希表(List数据类型作为map的key)(用这个就不用加"-"标识了)
    public int equalPairs2(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<List<Integer>, Integer>();
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int num : row) {
                arr.add(num);
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr.add(grid[i][j]);
            }
            if (cnt.containsKey(arr)) {
                res += cnt.get(arr);
            }
        }
        return res;
    }

}
