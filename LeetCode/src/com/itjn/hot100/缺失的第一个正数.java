package com.itjn.hot100;

import java.util.*;

public class 缺失的第一个正数 {
    public static void main(String[] args) {
        int i = firstMissingPositive1(new int[]{1});
        System.out.println(i);
    }

    //先排序后查找 (时间复杂度为 O(nlogn)，不符题意)
    public static int firstMissingPositive(int[] nums) {
        nums = Arrays.stream(nums).distinct().sorted().toArray();//去重排序
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0){
                continue;
            }
            if(nums[i] != count){
                return count;
            }
            count++;
        }
        return count;
    }

    //时间复杂度符合，但是空间复杂度没有做到"只使用常数级别额外空间"
    public static int firstMissingPositive1(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length + 1;
    }

    //时间复杂度为O(n)并且只使用常数级别额外空间 的解法
    //用题目本身的数组模拟成一个原地哈希表(支持快速查找)
    public static int firstMissingPositive2(int[] nums){
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0){//把数组所有的数都变成正数
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if(abs >= n + 1){
                continue;
            }
            if(nums[abs - 1] > 0){
                nums[abs - 1] = -nums[abs - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }



}
