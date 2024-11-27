package com.itjn.bucketSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;

public class oneHundredAndSixtyFour {

    public static void main(String[] args) {
        int i = maximumGap(new int[]{3, 6, 9, 1});
        System.out.println(i);
    }

    public static int maximumGap(int[] nums) {
        if(nums.length < 2)return 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i + 1]-nums[i]);
        }
        return max;
    }

}
