package com.itjn.interview150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.function.BiConsumer;

public class oneHundredAndSixtyNine {
    public static void main(String[] args) {
        int i = majorityElement1(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
    }


    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //Hash
    public static int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if(map.get(key) > nums.length/2)
                return key;
        }
        /*map.forEach((key, value) -> {
            if (value > nums.length/2) {
                System.out.println(key);
            }
        });*/
        return 0;
    }

}
