package com.itjn.hot100;

import java.util.*;

public class fiftySix {
    public static void main(String[] args) {
        int[][] merge = merge1(new int[][]{{1,4},{0,2},{3,5}});
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

    //二刷
    public static int[][] merge1(int[][] intervals){
        Arrays.sort(intervals,(o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > list.get(index)[1]){
                list.add(intervals[i]);
                index++;
            }else{
                if(intervals[i][1] > list.get(index)[1]){
                    //第一种覆盖方式
                    list.get(index)[1] = intervals[i][1];
                    //第二种覆盖方式
                    //int[] temp = {list.get(index)[0], intervals[i][1]};
                    //list.set(index, temp);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
