package com.itjn.heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的第k个最大元素 {
    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }

    //优先队列(堆)：基于堆排序的选择方法
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    //快速排序
    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //计数排序/桶排序
    public static int findKthLargest2(int[] nums, int k) {
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if(k <= 0){
                return i - 10000;
            }
        }
        return 0;
    }

}
