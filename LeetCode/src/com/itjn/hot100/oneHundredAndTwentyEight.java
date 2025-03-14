package com.itjn.hot100;

import java.util.*;

public class oneHundredAndTwentyEight {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    //方法二：HashSet  (时间复杂度为 O(n))
    public static int longestConsecutive1(int[] nums) {
        //1.通过set集合对数组进行去重
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        for (int s : set) {
            if(!set.contains(s - 1)){//2.set集合可以调用contains
                int CurrentCount = 1;
                while(set.contains(s + 1)){
                    CurrentCount++;
                    s++;
                }
                count = Math.max(count, CurrentCount);
            }
        }
        return count;
    }

    //方法一：先排序，去重。然后一次循环累加   (时间复杂度为 O(nlogn))(因为快速排序的时间复杂度为O(nlogn))
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);//排序
        nums = Arrays.stream(nums).distinct().toArray();//去重
        int max = 0;
        int count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i] + 1;
            if (nums[i + 1] == temp) {
                count++;//count只要不被打断就一直叠加
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        //特殊情况
        if (nums.length == 1) {
            max = 1;
        }
        return max;
    }


}
