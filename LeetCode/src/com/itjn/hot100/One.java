package com.itjn.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int target;
        int[] num = new int[length];

        for (int i = 0; i < length; i++) {
            num[i] = sc.nextInt();
        }
        target = sc.nextInt();
        int[] arr = twoSum(num, target);
        System.out.print("[" + arr[0] + "," + arr[1] + "]");

    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


}
