package com.itjn.slidingWindow;

import java.util.*;
import java.util.stream.Collectors;

public class twoHundredAndTwenty {

    public static void main(String[] args) {
        boolean b = containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},
                2, 3);
        System.out.println(b);
    }
    //list.sort((a, b) -> a - b);

    //滑动窗口 + TreeSet
    //TreeSet(1.可排序 2.支持范围查询)
    //查询：能够在「有序集合」中应用「二分查找」，
    //快速找到「小于等于 u 的最大值」和「大于等于 u 的最小值」（即「有序集合」中的最接近 u 的数）。
    //插入/删除：复杂度是 O(logN)，快。
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        int l = 0;
        set.add(nums[0]);
        for (int r = 1; r < nums.length;) {
            if(l < r && Math.abs(l - r) > indexDiff){
                set.remove(nums[l]);
                l++;
            }else{
                //求出小于或等于nums[r]的最大元素，如果没有这样的元素，则返回null。
                Integer floor = set.floor(nums[r]);
                //求出大于或等于nums[r]的最小元素，如果没有这样的元素，则返回null。
                Integer ceiling = set.ceiling(nums[r]);
                if(floor != null && Math.abs(nums[r] - floor) <= valueDiff)
                    return true;
                if(ceiling != null && Math.abs(nums[r] - ceiling) <= valueDiff)
                    return true;
                set.add(nums[r]);
                r++;
            }
        }

        return false;
    }


    //方法二：滑动窗口 + 桶排序
    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int indexDiff, int valueDiff) {



        return false;
    }


}
