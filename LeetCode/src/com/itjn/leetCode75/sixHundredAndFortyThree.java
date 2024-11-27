package com.itjn.leetCode75;

public class sixHundredAndFortyThree {
    public static void main(String[] args) {
        double maxAverage = findMaxAverage(new int[]{-1}, 1);
        System.out.println(maxAverage);
    }

    //滑动窗口
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double avg = 0;
        int sum = 0;
        for (int m = 0; m < k; m++) {
            sum += nums[m];
        }
        int maxSum = sum;
        for (int i = 1; i <= n - k; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            maxSum = Math.max(maxSum,sum);
        }
        avg = (double) maxSum / (double) k;
        return avg;
    }


}
