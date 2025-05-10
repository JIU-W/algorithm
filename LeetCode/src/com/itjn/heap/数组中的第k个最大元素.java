package com.itjn.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的第k个最大元素 {
    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.peek();
    }

}
