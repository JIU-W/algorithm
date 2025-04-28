package com.itjn.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class 下一个更大元素2 {
    public static void main(String[] args) {


    }

    //单调栈 + 循环数组
    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == max)res[i] = -1;
        }
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();

        //二次遍历数组
        for (int i = 0; i < 2 * n - 1; i++) {
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()]){
                Integer pop = stack.pop();
                res[pop] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }

}
