package com.itjn.hot100;

import java.util.HashMap;

public class fiveHundredAndSixty {
    public static void main(String[] args) {
        int i = subarraySum(new int[]{-1, -1, 1}, 0);
        System.out.println(i);
    }

    //前缀和 + 哈希表优化
    public static int subarraySum(int[] nums, int k) {
        int count = 0, preSum = 0;
        HashMap <Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];//这里我们可以不用建立前缀和 数组preSum[],
            //直接用 preSum 变量来记录

            //原理式子：preSum - (preSum - k) == k
            if (mp.containsKey(preSum - k)) {
                count += mp.get(preSum - k);
            }
            mp.put(preSum, mp.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    //暴力枚举
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }


    //滑动窗口(这题不能使用滑动窗口，因为数组元素可能为负数)
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int l = 0,r = 0;
        int sum = nums[0];
        while(r < nums.length && l < nums.length) {//l < nums.length:防止左指针越界
            if(sum < k){
                r++;
                if(r < nums.length)sum += nums[r];//防止右指针越界
            }else if(sum == k){
                count++;
                sum -= nums[l];
                l++;
            }else{
                sum -= nums[l];
                l++;
            }
        }
        return count;
    }


}
