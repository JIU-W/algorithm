package com.itjn.hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] arr = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(arr.toString());
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        //队列中每个元素是一个整型数组
        //按第一个元素 降序排列，如果若第一个元素相等，则按第二个元素 降序排列
        /*PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });*/
        //Lambda表达式写法
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) ->
                pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);

        return res;
    }



}
