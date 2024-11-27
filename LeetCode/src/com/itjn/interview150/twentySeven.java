package com.itjn.interview150;

public class twentySeven {
    public static void main(String[] args) {
        int i = removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println(i);
    }

    //双指针
    public static int removeElement(int[] nums, int val) {
        int j = 0;//准备j指针
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                count++;
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return count;
    }


}
