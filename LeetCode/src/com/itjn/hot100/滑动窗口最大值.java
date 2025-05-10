package com.itjn.hot100;

import java.util.*;

public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] arr = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(arr));
    }

    //方法一：优先队列
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        //PriorityQueue是一种基于优先级堆(Priority Heap)实现的队列，它允许元素按指定的顺序(自然顺序或自定义顺序)动态排序
        //队列中每个元素是一个整型数组，自定义排序规则：按第一个元素 降序排列，如果若第一个元素相等，则按第二个元素 降序排列
        /*PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });*/
        //Lambda表达式写法
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) ->
                pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        res[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {//检查队列最大值(队首元素)是否是在定长滑动内部，如果不在则要去除
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }

    //方法二：单调队列
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    //二刷：优先队列
    public int[] maxSlidingWindow2(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        res[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while(queue.peek()[1] <= i - k){
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }

}
