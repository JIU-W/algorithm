package com.itjn.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class twoHundredAndNineteen {
    public static void main(String[] args) {
        boolean b = containsNearbyDuplicate1(new int[]{1,2,3,1,2,3}, 2);
        System.out.println(b);
    }

    //哈希表，HashMap解法
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }else{
                if(Math.abs(i - map.get(nums[i])) <=k) return true;
                map.put(nums[i], i);
            }
        }
        return false;
    }

    //滑动窗口 + 利用Set的不可重复性
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        for (int r = 0; r < nums.length; ) {
            if(l <= r && Math.abs(r - l) > k){
                set.remove(nums[l]);
                l++;
            }else{
                boolean b = set.add(nums[r]);
                if(b == false)return true;
                r++;
            }
        }
        return false;
    }


}
