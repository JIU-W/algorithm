package com.itjn.slidingWindow;

public class oneThousandFourHundredAndNinetyThree {
    public static void main(String[] args) {
        int i = longestSubarray1(new int[]{1, 1, 1});
        System.out.println(i);
    }

    //滑动窗口
    public static int longestSubarray(int[] nums) {
        int includedZero = 0;
        int max = 0;
        int l = 0;
        int count = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                count++;
                includedZero = 1;
            }
            while (count > 1) {
                count -= 1 - nums[l];
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        if (includedZero == 0) return nums.length - 1;
        if (count == 1) return max - 1;
        return max;
    }

    //二刷
    public static int longestSubarray1(int[] nums) {
        int zeroCount = 0, max = 0, l = 0;
        for (int r = 0; r < nums.length; r++) {
            if(nums[r] == 0)zeroCount++;
            while(zeroCount > 1){
                zeroCount = zeroCount - (1 - nums[l]);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        if(zeroCount == 0)return nums.length - 1;
        return max - 1;
    }


}
