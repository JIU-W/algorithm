package com.itjn.prefixAnd;

import java.util.HashMap;

public class fiveHundredAndTwentyThree {
    public static void main(String[] args) {
        boolean b = checkSubarraySum1(new int[]{23, 2, 4, 6, 7}, 6);
        System.out.println(b);
    }

    //方法二：前缀和 + 哈希
    public static boolean checkSubarraySum1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sums[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < sums.length; i++) {
            if(map.containsKey(sums[i] % k)){
                if(i - map.get(sums[i] % k) >= 2){
                    return true;
                }
            }else{
                map.put(sums[i] % k, i);
            }
        }

        return false;
    }

    //方法一：暴力
    public static boolean checkSubarraySum(int[] nums, int k) {
        int sums[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                //if((sums[j + 1] - sums[i]) % k == 0)return true;
                temp = temp + nums[j];
                if(temp % k == 0)return true;
            }
        }

        return false;
    }


}
