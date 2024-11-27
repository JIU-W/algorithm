package com.itjn.leetCode75;

public class sevenHundredAndTwentyFour {
    public static void main(String[] args) {
        int i = pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(i);
    }

    public static int pivotIndex(int[] nums) {
        int sum[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                sum[i] = nums[i];
            }else{
                sum[i] = sum[i - 1] + nums[i];
            }
        }
        for (int i = 0; i < sum.length; i++) {
            if(i == 0 && sum[sum.length - 1] - sum[i] == 0 ){
                return i;
            }
            if(i == sum.length - 1 && sum[sum.length - 2] == 0 ){
                return i;
            }

            if(i != 0 && i != sum.length - 1 && sum[i - 1] == sum[sum.length - 1] - sum[i]){
                return i;
            }
        }
        return -1;
    }

}
