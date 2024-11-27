package com.itjn.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class fiftySix {
    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}});
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    //排序
    public static int[][] merge(int[][] intervals) {
        //根据左边界排序
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        /*Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });*/
        //根据右边界排序
        //Arrays.sort(intervals,(a, b) -> a[1] - b[1]);
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int m = list.size();
            if(m > 0 && interval[0] <= list.get(m - 1)[1]){//条件符合，可以合并
                list.get(m - 1)[1] = Math.max(list.get(m - 1)[1], interval[1]);//更新右端点为较大值
            }else{//不符合，直接添加
                list.add(interval);
            }
        }
        int[][] ans = list.toArray(new int[list.size()][]);
        return ans;
    }

}
